package com.alevel.backend.controller;

import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.domain.user.User;
import com.alevel.backend.service.MailService;
import com.alevel.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 로그인
     */
    @GetMapping(value = "/users/login")
    public ResultResponse login(@Valid String email, String password) {
        User user = userService.login(email, password);
        return ResultResponse.success(user.getId());
    }

    /**
     * 회원가입
     */
    @PostMapping(value = "/users/signup")
    public ResultResponse signup(String email, String password, String username) {
        userService.validateDuplicateEmail(email);
        userService.validateDuplicateUsername(username);
        User user = userService.signup(email, password, username);
        return ResultResponse.success(user.getId());
    }

    /**
     * 별명 중복확인
     */
    @GetMapping(value = "/users/check/{username}")
    public ResultResponse checkUsername(@PathVariable("username") String username) {
        userService.validateDuplicateUsername(username);
        return ResultResponse.success();
    }

    /**
     * 이메일 인증
     */
    @GetMapping(value = "/users/check/email")
    public ResultResponse checkEmail(@Valid String email) {
        try {
            userService.validateDuplicateEmail(email);
            System.out.println("가입 가능한 이메일: " + email);
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.CONFLICT, ResponseMessage.DUPLICATED_EMAIL);
        }

        int key = mailService.createKey();
        String subject = "[한잔할래] 회원가입 인증 메일입니다.";
        String content = "인증번호 : " + key +
                "<br>";
        if (mailService.sendMail(email, subject, content)) {
            return ResultResponse.success();
        } else {
            return ResultResponse.fail(StatusCode.INTERNAL_SERVER_ERROR, ResponseMessage.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 회원탈퇴
     */
    @PutMapping(value = "/users/withdrawal")
    public ResultResponse withdrawal(Long id) {
        userService.remove(id);
        return ResultResponse.success();
    }

    /**
     * 별명 변경
     */
    @PutMapping(value = "/users/username/{id}")
    public ResultResponse putUsername(@PathVariable("id") Long id, String username) {
        userService.validateDuplicateUsername(username);
        userService.updateUsername(id, username);
        return ResultResponse.success();
    }

    /**
     * 비밀번호 변경
     */
    @PutMapping(value = "/users/password/{id}")
    public ResultResponse updatePassword(@PathVariable("id") Long id, String password, String passwordConfirm) {
        if (!password.equals(passwordConfirm)) {
            return ResultResponse.fail(StatusCode.BAD_REQUEST, ResponseMessage.INVALIDATED_PASSWORD);
        }
        userService.updatePassword(id, password);
        return ResultResponse.success();
    }

    /**
     * 내 계정 조회
     */
    @GetMapping(value = "/users/mypage/{id}")
    public ResultResponse getMypageAccount(@PathVariable("id") Long id) {
        return ResultResponse.success(userService.getAccount(id));
    }

}

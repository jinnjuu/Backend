package com.alevel.backend.controller;

import com.alevel.backend.domain.response.DefaultResponse;
import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.domain.user.User;
import com.alevel.backend.service.MailService;
import com.alevel.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping(value = "/user/login")
    public ResponseEntity login(@Valid String email, String password) {
        return new ResponseEntity(userService.login(email, password), HttpStatus.OK);
    }

    /**
     * 회원가입
     */
    @PostMapping(value = "/user/signup")
    public ResponseEntity signup(String email, String password, String username) {
        userService.validateDuplicateUsername(username);
        userService.validateDuplicateEmail(email);
        User data = userService.signup(email, password, username);
        return new ResponseEntity(new DefaultResponse(data), HttpStatus.OK);
    }

    /**
     * 별명 중복확인
     */
    @GetMapping(value = "/user/check/{username}")
    public ResponseEntity<String> checkUsername(@PathVariable("username") String username) {
        try {
            userService.validateDuplicateUsername(username);
            return new ResponseEntity(new DefaultResponse(StatusCode.OK, ResponseMessage.NOT_DUPLICATED, username), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new DefaultResponse(StatusCode.CONFLICT, ResponseMessage.DUPLICATED, username), HttpStatus.CONFLICT);
        }
    }

    /**
     * 이메일 인증
     */
    @GetMapping(value = "/user/check/email")
    public ResponseEntity<String> checkEmail(@Valid String email) {
        try {
            userService.validateDuplicateEmail(email);
            System.out.println("가입 가능한 이메일: " + email);
        } catch (Exception e) {
            return new ResponseEntity(new DefaultResponse(StatusCode.CONFLICT, ResponseMessage.DUPLICATED, email), HttpStatus.CONFLICT);
        }

        int key = mailService.createKey();
        String subject = "[한잔할래] 회원가입 인증 메일입니다.";
        String content = "인증번호 : " + key +
                "<br>";
        if (mailService.sendMail(email, subject, content)) {
            return new ResponseEntity(new DefaultResponse(StatusCode.OK, ResponseMessage.SUCCESS, key), HttpStatus.OK);
        } else {
            return new ResponseEntity(new DefaultResponse(StatusCode.BAD_REQUEST, ResponseMessage.FAIL, key), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * 회원탈퇴
     */
    @PutMapping(value = "/user/withdrawal")
    public ResponseEntity<String> withdrawal(Long id) {
        return new ResponseEntity(userService.remove(id), HttpStatus.OK);
    }

    /**
     * 별명 변경
     */
    @PutMapping(value = "/user/username/{id}")
    public ResponseEntity<String> putUsername(@PathVariable("id") Long id, String username) {
        try {
            userService.validateDuplicateUsername(username);
            userService.updateUsername(id, username);
            return new ResponseEntity(new DefaultResponse(StatusCode.OK, ResponseMessage.SUCCESS, username), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new DefaultResponse(StatusCode.CONFLICT, ResponseMessage.DUPLICATED, username), HttpStatus.CONFLICT);
        }
    }

    /**
     * 비밀번호 변경
     */
    @PutMapping(value = "/user/password/{id}")
    public ResponseEntity<String> updatePassword(@PathVariable("id") Long id, String password, String passwordConfirm) {
        if (!password.equals(passwordConfirm)) {
            return new ResponseEntity(new DefaultResponse(StatusCode.BAD_REQUEST, ResponseMessage.FAIL), HttpStatus.BAD_REQUEST);
        }
        userService.updatePassword(id, password);
        return new ResponseEntity(new DefaultResponse(id), HttpStatus.OK);
    }

    /**
     * 내 계정 조회
     */
    @GetMapping(value = "/users/mypage/{id}")
    public ResponseEntity<String> getMypageAccount(@PathVariable("id") Long id) {
        return new ResponseEntity(new DefaultResponse(userService.getAccount(id)), HttpStatus.OK);
    }

}

package com.alevel.backend.controller;

import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.domain.user.User;
import com.alevel.backend.dto.LoginDto;
import com.alevel.backend.dto.UserDto;
import com.alevel.backend.jwt.CustomUserDetails;
import com.alevel.backend.jwt.TokenProvider;
import com.alevel.backend.service.AuthService;
import com.alevel.backend.service.MailService;
import com.alevel.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/")
public class UserController {

    private final AuthService authService;
    private final UserService userService;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    @Autowired
    private MailService mailService;

    @Autowired
    public UserController(
            AuthService authService,
            UserService userService,
            AuthenticationManagerBuilder authenticationManagerBuilder,
            TokenProvider tokenProvider) {
        this.authService = authService;
        this.userService = userService;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.tokenProvider = tokenProvider;
    }


    /**
     * 로그인
     */
    @PostMapping("/login")
    public ResultResponse authorize(@Valid @RequestBody LoginDto loginDto) {
        return ResultResponse.success(authService.login(loginDto));
    }

    /**
     * 회원가입
     */
    @PostMapping(value = "/signup")
    public ResultResponse signup(@RequestBody UserDto dto) {
        userService.validateDuplicateEmail(dto.getEmail());
        userService.validateDuplicateUsername(dto.getUsername());
        User user = userService.signup(dto);
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
    @PostMapping(value = "/users/check/email")
    public ResultResponse sendEmail(@NotNull String email) {
        try {
            userService.validateDuplicateEmail(email);
            System.out.println("가입 가능한 이메일: " + email);
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.CONFLICT, ResponseMessage.DUPLICATED_EMAIL);
        }

        if (mailService.sendMail(email)) {
            return ResultResponse.success();
        } else {
            return ResultResponse.fail(StatusCode.INTERNAL_SERVER_ERROR, ResponseMessage.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 인증 확인
     */
    @GetMapping(value = "/users/check/email")
    public ResultResponse confirmToken(String email, String token) {
        try {
            mailService.confirmToken(email, token);
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.NOT_FOUND, ResponseMessage.INVALIDATED_TOKEN);
        }
        return ResultResponse.success();
    }

    /**
     * 회원탈퇴
     */
    @PutMapping(value = "/users/withdrawal")
    public ResultResponse withdrawal(@AuthenticationPrincipal CustomUserDetails user) {
        userService.remove(user.getId());
        return ResultResponse.success();
    }

    /**
     * 별명 변경
     */
    @PutMapping(value = "/users/username")
    public ResultResponse putUsername(String username, @AuthenticationPrincipal CustomUserDetails user) {
        userService.validateDuplicateUsername(username);
        User principal = userService.updateUsername(user.getId(), username);
        return ResultResponse.success();
    }

    /**
     * 비밀번호 변경
     */
    @PutMapping(value = "/users/password")
    public ResultResponse updatePassword(String password, String passwordConfirm, @AuthenticationPrincipal CustomUserDetails user) {
        if (!password.equals(passwordConfirm)) {
            return ResultResponse.fail(StatusCode.BAD_REQUEST, ResponseMessage.INVALIDATED_PASSWORD);
        }
        userService.updatePassword(user.getId(), password);
        return ResultResponse.success();
    }

    /**
     * 내 계정 조회
     */
    @GetMapping(value = "/users/mypage")
    public ResultResponse getMypageAccount(@AuthenticationPrincipal CustomUserDetails user) {
        return ResultResponse.success(userService.getAccount(user.getId()));
    }

}

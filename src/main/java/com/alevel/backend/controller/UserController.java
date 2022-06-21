package com.alevel.backend.controller;

import com.alevel.backend.domain.response.DefaultResponse;
import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.domain.user.User;
import com.alevel.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 회원가입
     */
    @PostMapping(value = "/user/signup")
    public ResponseEntity signup(String email, String password, String username) {
        userService.validateDuplicateUsername(username);
        userService.validateDuplicateEmail(email);
        User data = userService.signup(email, password, username);
        return new ResponseEntity(new DefaultResponse(StatusCode.OK, ResponseMessage.SUCCESS, data), HttpStatus.OK);
    }

    /**
     * 별명 중복확인
     */
    @GetMapping(value = "/user/check/{username}")
    public ResponseEntity<String> validateDuplicateUsername(@PathVariable("username") String username) {
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
    public ResponseEntity<String> validateDuplicateEmail(@Valid String email) {
        try {
            userService.validateDuplicateEmail(email);
            return new ResponseEntity(new DefaultResponse(StatusCode.OK, ResponseMessage.NOT_DUPLICATED, email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new DefaultResponse(StatusCode.CONFLICT, ResponseMessage.DUPLICATED, email), HttpStatus.CONFLICT);
        }
    }


}

package com.alevel.backend.controller;

import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.exception.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.LimitExceededException;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {

    @ExceptionHandler(InvalidateUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResultResponse InvalidateUserException(InvalidateUserException e) {
        log.info(e.getMessage());
        e.printStackTrace();
        return ResultResponse.fail(StatusCode.NOT_FOUND, ResponseMessage.INVALIDATED_USER);
    }

    @ExceptionHandler(WithdrawnUserException.class)
    private ResultResponse WithdrawnUserException(WithdrawnUserException e) {
        log.info(e.getMessage());
        e.printStackTrace();
        return ResultResponse.fail(StatusCode.NOT_FOUND, ResponseMessage.WITHDRAWN_USER);
    }

    @ExceptionHandler(InvalidatePasswordException.class)
    private ResultResponse InvalidatePasswordException(InvalidatePasswordException e) {
        log.info(e.getMessage());
        e.printStackTrace();
        return ResultResponse.fail(StatusCode.UNAUTHORIZED, ResponseMessage.INVALIDATED_PASSWORD);
    }

    @ExceptionHandler(DuplicatedUserException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    private ResultResponse DuplicatedUserException(DuplicatedUserException e) {
        log.info(e.getMessage());
        e.printStackTrace();
        return ResultResponse.fail(StatusCode.CONFLICT, ResponseMessage.DUPLICATED_USERNAME);
    }

    @ExceptionHandler(DuplicatedEmailException.class)
    private ResultResponse DuplicatedEmailException(DuplicatedEmailException e) {
        log.info(e.getMessage());
        e.printStackTrace();
        return ResultResponse.fail(StatusCode.CONFLICT, ResponseMessage.DUPLICATED_EMAIL);
    }

    @ExceptionHandler(ExceededNumberException.class)
    private ResultResponse ExceededNumberException(ExceededNumberException e) {
        log.info(e.getMessage());
        e.printStackTrace();
        return ResultResponse.fail(StatusCode.BAD_REQUEST, ResponseMessage.EXCEEDED_NUMBER);
    }
}

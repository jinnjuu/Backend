package com.alevel.backend.domain.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ResultResponse<T> implements Serializable {

    private int status;
    private String message;
    private T data;

    public static ResultResponse success() {
        ResultResponse response = ResultResponse.builder()
                .status(StatusCode.OK)
                .message(ResponseMessage.SUCCESS)
                .build();
        return response;
    }

    public static <T> ResultResponse success(T data) {
        ResultResponse response = ResultResponse.builder()
                .status(StatusCode.OK)
                .message(ResponseMessage.SUCCESS)
                .data(data)
                .build();
        return response;
    }

    public static ResultResponse fail(int status, String message) {
        ResultResponse response = ResultResponse.builder()
                .status(status)
                .message(message)
                .build();
        return response;
    }
}

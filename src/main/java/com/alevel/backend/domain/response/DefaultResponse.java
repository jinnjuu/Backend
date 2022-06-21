package com.alevel.backend.domain.response;

import lombok.Data;

@Data
public class DefaultResponse {

    private int status;
    private String message;
    private Object data;

    public DefaultResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public DefaultResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}

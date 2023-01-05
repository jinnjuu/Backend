package com.alevel.backend.dto;

import lombok.Data;

import javax.validation.Valid;

@Data
public class LoginDto {
    @Valid
    private String email;
    private String password;
}

package com.alevel.backend.controller.dto;

import com.alevel.backend.domain.user.User;
import lombok.Getter;

@Getter
public class MypageAccountResponseDto {

    private String username;
    private String email;
    private String password;

    public MypageAccountResponseDto(User entity){
        this.username = entity.getUsername();
        this.email = entity.getEmail();
        this.password = ("*********");
    }
}

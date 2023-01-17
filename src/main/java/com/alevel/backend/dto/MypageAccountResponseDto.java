package com.alevel.backend.dto;

import com.alevel.backend.domain.user.User;
import lombok.Getter;

@Getter
public class MypageAccountResponseDto {

    private final String username;
    private final String email;
    private final String password;

    public MypageAccountResponseDto(User entity){
        this.username = entity.getUsername();
        this.email = entity.getEmail();
        this.password = ("*********");
    }
}

package com.alevel.backend.controller.dto.MypageTab;

import com.alevel.backend.domain.user.User;
import lombok.Getter;

@Getter
public class MypageTabNameDto {

    private String username;

    public MypageTabNameDto(User UserEntity){
        this.username=UserEntity.getUsername();
    }
}

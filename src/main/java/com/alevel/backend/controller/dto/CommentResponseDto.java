package com.alevel.backend.controller.dto;

import com.alevel.backend.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private String username;
    private String content;
    private LocalDateTime modifiedDate;

    public CommentResponseDto(User user, String content, LocalDateTime modifiedDate){
        this.username = user.getUsername();
        this.content = content;
        this.modifiedDate = modifiedDate;
    }
}

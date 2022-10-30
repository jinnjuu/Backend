package com.alevel.backend.dto;

import com.alevel.backend.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private final String username;
    private final String content;
    private final LocalDateTime modifiedDate;

    public CommentResponseDto(User user, String content, LocalDateTime modifiedDate){
        this.username = user.getUsername();
        this.content = content;
        this.modifiedDate = modifiedDate;
    }
}

package com.alevel.backend.controller.dto;

import com.alevel.backend.domain.comment.Comment;
import lombok.Getter;

@Getter
public class MypageCommentResponseDto {
    private String content;

    public MypageCommentResponseDto(Comment entity){
        this.content=entity.getContent();
    }
}

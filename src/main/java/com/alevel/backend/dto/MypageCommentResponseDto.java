package com.alevel.backend.dto;

import com.alevel.backend.domain.comment.Comment;
import lombok.Getter;

@Getter
public class MypageCommentResponseDto {
    private final String content;

    public MypageCommentResponseDto(Comment entity){
        this.content=entity.getContent();
    }
}

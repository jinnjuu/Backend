package com.alevel.backend.controller.dto.MypageTab;

import com.alevel.backend.domain.comment.Comment;
import lombok.Getter;

@Getter
public class MypageTabCommentDto {

    private Integer myCommentCount;

    public MypageTabCommentDto(Comment CommentEntity){
        this.myCommentCount=CommentEntity.getMyCommentCount();
    }
}

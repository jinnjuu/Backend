package com.alevel.backend.dto;

import com.alevel.backend.domain.post.Post;
import lombok.Getter;

@Getter
public class MyPagePostResponseDto {

    private final String title;
    private final String content;
    private final Long id;
    private final String image;
    //댓글개수
    private final Integer commentCount;

    public MyPagePostResponseDto(Post entity){
        this.id= entity.getId();
        this.content=entity.getContent();
        this.title=entity.getTitle();
        this.commentCount=entity.getCommentCount();
        this.image=entity.getImage();
    }
}

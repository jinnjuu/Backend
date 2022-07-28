package com.alevel.backend.controller.dto;

import com.alevel.backend.domain.post.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long user_id;
    private String title;
    private String content;
    private Long id;
    private String image;

    public PostResponseDto(Post entity){
        this.id= entity.getId();
        this.content=entity.getContent();
        this.title=entity.getTitle();
        this.user_id=entity.getUser_id();
        this.image=entity.getImage();
    }
}

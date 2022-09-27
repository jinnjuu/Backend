package com.alevel.backend.controller.dto;

import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private String image;
    //댓글개수
    private Integer commentCount;
    private Integer scrapCount;
    private Integer likeCount;

    public PostResponseDto(Long id, String title, String content, String image,
                           Integer commentCount, Integer scrapCount, Integer likeCount){
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.commentCount = commentCount;
        this.scrapCount = scrapCount;
        this.likeCount = likeCount;

    }

}

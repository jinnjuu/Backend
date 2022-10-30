package com.alevel.backend.dto;

import lombok.Getter;

@Getter
public class PostResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String image;
    //댓글개수
    private final Integer commentCount;
    private final Integer scrapCount;
    private final Integer likeCount;

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

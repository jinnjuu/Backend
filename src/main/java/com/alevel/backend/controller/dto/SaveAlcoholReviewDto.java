package com.alevel.backend.controller.dto;

import lombok.Getter;

@Getter
public class SaveAlcoholReviewDto {

    private Long alcoholid;
    private Long userid;
    private String content;

    public SaveAlcoholReviewDto(Long alcoholid, Long userid, String content) {
        this.alcoholid = alcoholid;
        this.userid = userid;
        this.content = content;
    }
}

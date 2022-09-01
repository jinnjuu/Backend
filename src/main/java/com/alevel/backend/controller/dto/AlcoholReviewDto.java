package com.alevel.backend.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AlcoholReviewDto {

    private Long userid;
    private String content;

    public AlcoholReviewDto(Long userid, String content) {
        this.userid = userid;
        this.content = content;
    }

}

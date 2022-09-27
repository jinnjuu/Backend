package com.alevel.backend.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AlcoholReviewResponseDto {

    private Long alcoholid;
    private String username;
    private String content;
    private LocalDateTime date;

    public AlcoholReviewResponseDto(Long alcoholid, String username, String content, LocalDateTime date) {
        this.alcoholid = alcoholid;
        this.username = username;
        this.content = content;
        this.date = date;
    }

}

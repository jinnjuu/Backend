package com.alevel.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AlcoholReviewResponseDto {

    private Long id;
    private Long alcoholId;
    private String username;
    private String content;
    private LocalDateTime date;

    public AlcoholReviewResponseDto(Long id, Long alcoholId, String username, String content, LocalDateTime date) {
        this.id = id;
        this.alcoholId = alcoholId;
        this.username = username;
        this.content = content;
        this.date = date;
    }

}

package com.alevel.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContentRequestDto {

    private String content;

    public ContentRequestDto(String content) {
        this.content = content;
    }

}

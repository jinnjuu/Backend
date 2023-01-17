package com.alevel.backend.dto;

import lombok.Getter;

@Getter
public class RecommendAlcoholDto {

    private String image;
    private String name;

    public RecommendAlcoholDto() {

    }
    
    public RecommendAlcoholDto(String image, String name){
        this.image = image;
        this.name = name;
    }
}

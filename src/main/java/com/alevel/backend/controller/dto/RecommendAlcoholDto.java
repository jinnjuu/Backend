package com.alevel.backend.controller.dto;

import com.alevel.backend.domain.alcohol.Alcohol;
import lombok.Getter;

@Getter
public class RecommendAlcoholDto {

    private String image;
    private String name;

    public RecommendAlcoholDto() {

    }
    
    public RecommendAlcoholDto(Alcohol entity){
        this.image= entity.getImage();
        this.name=entity.getName();
    }
}

package com.alevel.backend.controller.dto;

import com.alevel.backend.domain.alcohol.Alcohol;
import lombok.Getter;

@Getter
public class AlcoholDetailResponseDto {
    private final String name;
    private final String volume;
    private final String size;
    private final Integer price;
    private final String image;

    private final String flavor; // 맛
    private final String food; // 음식
    private final String type; // 주종
    private final String info; // 상세설명

    public AlcoholDetailResponseDto(Alcohol alcohol) {
        this.name = alcohol.getName();
        this.volume = alcohol.getVolume();
        this.size = alcohol.getSize();
        this.price = alcohol.getPrice();
        this.image = alcohol.getImage();

        this.flavor = alcohol.getFlavor();
        this.food = alcohol.getFood();
        this.type = alcohol.getType();
        this.info = alcohol.getInfo();
    }
}

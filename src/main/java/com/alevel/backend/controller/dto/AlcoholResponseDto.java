package com.alevel.backend.controller.dto;

import lombok.Getter;

@Getter
public class AlcoholResponseDto {
    private final String name;
    private final String volume;
    private final String size;
    private final Integer price;
    private final String image;

    private String flavor; // 맛
    private String food; // 음식
    private String type; // 주종
    private String info; // 상세설명

    public AlcoholResponseDto(String name, String volume, String size, Integer price, String image) {
        this.name = name;
        this.volume = volume;
        this.size = size;
        this.price = price;
        this.image = image;
    }

    public AlcoholResponseDto(String name, String volume, String size, Integer price, String image,
                                    String flavor, String food, String type, String info) {
        this.name = name;
        this.volume = volume;
        this.size = size;
        this.price = price;
        this.image = image;

        this.flavor = flavor;
        this.food = food;
        this.type = type;
        this.info = info;
    }
}

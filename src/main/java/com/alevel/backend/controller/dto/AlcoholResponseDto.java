package com.alevel.backend.controller.dto;

import lombok.Getter;

@Getter
public class AlcoholResponseDto {
    private final String name;
    private final String volume;
    private final String size;
    private final Integer price;
    private final String image;

    public AlcoholResponseDto(String name, String volume, String size, Integer price, String image) {
        this.name = name;
        this.volume = volume;
        this.size = size;
        this.price = price;
        this.image = image;
    }
}

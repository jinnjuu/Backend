package com.alevel.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PreferenceRequestDto {
    private String type;
    private int volume;
    private int sugar;
    private String flavor;
    private String price;
}

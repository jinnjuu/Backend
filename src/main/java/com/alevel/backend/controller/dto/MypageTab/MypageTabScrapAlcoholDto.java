package com.alevel.backend.controller.dto.MypageTab;

import com.alevel.backend.domain.scrapalcohol.ScrapAlcohol;
import lombok.Getter;

@Getter
public class MypageTabScrapAlcoholDto {
    private Integer myScrapAlcoholCount;

    public MypageTabScrapAlcoholDto(ScrapAlcohol scrapAlcoholEntity){
        this.myScrapAlcoholCount= scrapAlcoholEntity.getMyScrapAlcoholCount();
    }

}

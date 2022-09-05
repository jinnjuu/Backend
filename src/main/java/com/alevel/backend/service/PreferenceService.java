package com.alevel.backend.service;

import com.alevel.backend.controller.dto.RecommendAlcoholDto;
import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.domain.alcohol.AlcoholRepository;
import com.alevel.backend.domain.preference.Preference;
import com.alevel.backend.domain.preference.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private final AlcoholRepository alcoholRepository;

    @Autowired
    public PreferenceService(PreferenceRepository preferenceRepository, AlcoholRepository alcoholRepository) {
        this.preferenceRepository = preferenceRepository;
        this.alcoholRepository = alcoholRepository;
    }

    public Preference insert(Preference preference) {
        return preferenceRepository.save(preference);
    }

    public String getRecommendationId(Preference preference) {

        String[] typeArray = preference.getType().split(",");
        Integer volume = preference.getVolume();
        Integer sugar = preference.getSugar();
        String flavor = preference.getFlavor();
        Integer minPrice = Integer.parseInt(preference.getPrice().split(",")[0]);
        Integer maxPrice = Integer.parseInt(preference.getPrice().split(",")[1]);

        String resultList = alcoholRepository.findRecommend(typeArray, volume, sugar, flavor, minPrice, maxPrice).toString();
        String result = resultList.substring(1).substring(0, resultList.length() -2);

        return result;
    }

    public List<RecommendAlcoholDto> findRecommendationAlcohol (Long userid, String type) {
        List<RecommendAlcoholDto> result = new ArrayList();
        String recommendation = preferenceRepository.findRecommendationByUserid(userid);
        String[] IdArray = recommendation.replaceAll(" ","").split(",");

        for (int i = 0; i < IdArray.length; i++) {
            Alcohol alcohol = alcoholRepository.findAlcoholById(Long.parseLong(IdArray[i]));

            if (type.equals("") || alcohol.getType().equals(type)) {
                result.add(new RecommendAlcoholDto(alcohol));
            }
        }
        return result;
    }
}

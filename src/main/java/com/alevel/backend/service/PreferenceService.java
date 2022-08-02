package com.alevel.backend.service;

import com.alevel.backend.domain.alcohol.AlcoholRepository;
import com.alevel.backend.domain.preference.Preference;
import com.alevel.backend.domain.preference.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String getRecommendation(Preference preference, String type) {

        String[] typeArray = preference.getType().split(",");
        Integer volume = preference.getVolume();
        Integer sugar = preference.getSugar();
        String flavor = preference.getFlavor();
        Integer minPrice = Integer.parseInt(preference.getPrice().split(",")[0]);
        Integer maxPrice = Integer.parseInt(preference.getPrice().split(",")[1]);

        List<Long> resultList = alcoholRepository.findRecommend(typeArray, volume, sugar, flavor, minPrice, maxPrice);
        String result = resultList.toString().substring(1).substring(0, resultList.size() -1);

        return result;
    }

}

package com.alevel.backend.controller;

import com.alevel.backend.domain.preference.Preference;
import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PreferenceController {

    private final PreferenceService preferenceService;

    @Autowired
    public PreferenceController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    /**
     * 술 취향 등록
     */
    @PostMapping(value = "/users/preference")
    public ResultResponse savePreference(@RequestBody Preference preference) {
        try {
            String recommendation = preferenceService.getRecommendationId(preference);
            preference.setRecommendation(recommendation);
            return ResultResponse.success();
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.BAD_REQUEST, ResponseMessage.FAIL);
        }
    }

    /**
     * 술 추천
     */
    @GetMapping(value = "/recommendations/alcohol")
    public ResultResponse recommendAlcohol(Long userid, String type) {
        try {
            return ResultResponse.success(preferenceService.findRecommendationAlcohol(userid, type));
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.BAD_REQUEST, ResponseMessage.INVALIDATED_ALCOHOL);
        }
    }

}

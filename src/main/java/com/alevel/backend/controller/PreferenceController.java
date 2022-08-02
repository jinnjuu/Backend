package com.alevel.backend.controller;

import com.alevel.backend.domain.preference.Preference;
import com.alevel.backend.domain.response.DefaultResponse;
import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PreferenceController {

    private final PreferenceService preferenceService;

    @Autowired
    public PreferenceController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

//    @PostMapping(value = "/user/prefer")
//    public ResponseEntity savePrefer(@RequestBody Preference preference) {
//        return new ResponseEntity(preferenceService.insert(preference), HttpStatus.OK);
//    }

    /**
     * 술 취향 등록
     */
    @PostMapping(value = "/user/prefer")
    public ResponseEntity savePreference(@RequestBody Preference preference, String type) {
        try {
            String recommendation = preferenceService.getRecommendation(preference, type);
            preference.setRecommendation(recommendation);
            return new ResponseEntity(preferenceService.insert(preference), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new DefaultResponse(StatusCode.BAD_REQUEST, ResponseMessage.FAIL, preference), HttpStatus.BAD_REQUEST);
        }
    }
}

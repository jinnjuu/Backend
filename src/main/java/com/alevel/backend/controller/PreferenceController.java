package com.alevel.backend.controller;

import com.alevel.backend.domain.Preference;
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

    /**
     * 술 취향 등록
     */
    @PostMapping(value = "/user/prefer")
    public ResponseEntity savePrefer(@RequestBody Preference preference) {
        return new ResponseEntity(preferenceService.insert(preference), HttpStatus.OK);
    }

}

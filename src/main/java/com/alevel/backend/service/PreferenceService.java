package com.alevel.backend.service;

import com.alevel.backend.domain.Preference;
import com.alevel.backend.domain.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferenceService {

    private final PreferenceRepository preferenceRepository;

    @Autowired
    public PreferenceService(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    public Preference insert(Preference preference) {
        return preferenceRepository.save(preference);
    }
}

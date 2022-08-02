package com.alevel.backend.service;

import com.alevel.backend.domain.alcohol.AlcoholRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlcoholService {

    private final AlcoholRepository alcoholRepository;

    @Autowired
    public AlcoholService(AlcoholRepository alcoholRepository) {
        this.alcoholRepository = alcoholRepository;
    }

}

package com.alevel.backend.service;

import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.domain.alcohol.AlcoholRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SearchService {
    private final AlcoholRepository alcoholRepository;

    public SearchService(AlcoholRepository alcoholRepository) {
        this.alcoholRepository = alcoholRepository;
    }

    @Transactional
    public List<Alcohol> search(String name){
        List<Alcohol> alcoholList=alcoholRepository.findByNameContaining(name);
        return alcoholList;
    }
}

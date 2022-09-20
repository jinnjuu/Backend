package com.alevel.backend.service;

import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.domain.alcohol.AlcoholRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

@Service
public class AlcoholSearchService {
    private final AlcoholRepository alcoholRepository;

    public AlcoholSearchService(AlcoholRepository alcoholRepository) {
        this.alcoholRepository = alcoholRepository;
    }

    @Transactional
    public List<Alcohol> searchKeyword(String keyword){
        List<Alcohol> alcoholList=alcoholRepository.findByNameContaining(keyword);
        return alcoholList;
    }}

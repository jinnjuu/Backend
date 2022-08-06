package com.alevel.backend.service;

import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.domain.alcohol.AlcoholRepository;
import com.alevel.backend.domain.preference.Preference;
import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlcoholService {

    private final AlcoholRepository alcoholRepository;

    @Autowired
    public AlcoholService(AlcoholRepository alcoholRepository) {
        this.alcoholRepository = alcoholRepository;
    }

    private JPAQueryFactory queryFactory;

    public Page<Alcohol> findAllAlcohol(String type, String category, Pageable pageable) {
        return alcoholRepository.findAllAlcohol(type, category, pageable);
    }

}

package com.alevel.backend.service;

import com.alevel.backend.controller.dto.AlcoholDetailResponseDto;
import com.alevel.backend.controller.dto.AlcoholResponseDto;
import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.domain.alcohol.AlcoholRepository;
import com.alevel.backend.domain.scrapalcohol.ScrapAlcohol;
import com.alevel.backend.domain.scrapalcohol.ScrapAlcoholRepository;
import com.alevel.backend.domain.user.User;
import com.alevel.backend.domain.user.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlcoholService {

    private final AlcoholRepository alcoholRepository;
    private final ScrapAlcoholRepository scrapAlcoholRepository;
    private final UserRepository userRepository;

    @Autowired
    public AlcoholService(AlcoholRepository alcoholRepository, ScrapAlcoholRepository scrapAlcoholRepository, UserRepository userRepository) {
        this.alcoholRepository = alcoholRepository;
        this.scrapAlcoholRepository = scrapAlcoholRepository;
        this.userRepository = userRepository;
    }

    private JPAQueryFactory queryFactory;

    public Page<AlcoholResponseDto> findAllAlcohol(String type, String category, Pageable pageable) {
        return alcoholRepository.findAllAlcohol(type, category, pageable);
    }

    public AlcoholDetailResponseDto findAlcoholDetail(Long id) {
        Alcohol alcohol = alcoholRepository.findAlcoholById(id);
        return new AlcoholDetailResponseDto(alcohol);
    }

    public void scrapAlcohol(Long userId, Long alcoholId) {
        User user = userRepository.getReferenceById(userId);
        Alcohol alcohol = alcoholRepository.getReferenceById(alcoholId);

        scrapAlcoholRepository.findByUserAndAlcohol(user, alcohol).ifPresentOrElse(
                scrap -> {
                    scrapAlcoholRepository.delete(scrap);
                },
                () -> {
                    ScrapAlcohol scrapAlcohol = new ScrapAlcohol(user, alcohol);
                    scrapAlcoholRepository.save(scrapAlcohol);
                }
        );
    }
}

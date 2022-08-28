package com.alevel.backend.service;

import com.alevel.backend.controller.dto.SaveAlcoholReviewDto;
import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.domain.alcohol.AlcoholRepository;
import com.alevel.backend.domain.review.Review;
import com.alevel.backend.domain.review.ReviewRepository;
import com.alevel.backend.domain.user.User;
import com.alevel.backend.domain.user.UserRepository;
import com.alevel.backend.exception.ExceededNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final AlcoholRepository alcoholRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, AlcoholRepository alcoholRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.alcoholRepository = alcoholRepository;
    }

    public void saveReview(SaveAlcoholReviewDto dto){
        User user = userRepository.getReferenceById(dto.getUserid());
        Alcohol alcohol = alcoholRepository.getReferenceById(dto.getAlcoholid());

        if (dto.getContent().length()>100) {
            throw new ExceededNumberException();
        }
        else {
            reviewRepository.save(new Review(user, alcohol, dto.getContent()));
        }
    }
}

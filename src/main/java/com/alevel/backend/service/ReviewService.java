package com.alevel.backend.service;

import com.alevel.backend.controller.dto.AlcoholReviewResponseDto;
import com.alevel.backend.controller.dto.AlcoholReviewSaveDto;
import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.domain.alcohol.AlcoholRepository;
import com.alevel.backend.domain.review.Review;
import com.alevel.backend.domain.review.ReviewRepository;
import com.alevel.backend.domain.user.User;
import com.alevel.backend.domain.user.UserRepository;
import com.alevel.backend.exception.ExceededNumberException;
import com.alevel.backend.exception.InvalidateReviewException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public void saveReview(AlcoholReviewSaveDto dto){
        User user = userRepository.getReferenceById(dto.getUserid());
        Alcohol alcohol = alcoholRepository.getReferenceById(dto.getAlcoholid());

        if (dto.getContent().length()>100) {
            throw new ExceededNumberException();
        }
        else {
            reviewRepository.save(new Review(user, alcohol, dto.getContent()));
        }
    }

    public List<AlcoholReviewResponseDto> getReview(Long id){
        Alcohol alcohol = alcoholRepository.getReferenceById(id);
        List<Review> review = reviewRepository.findAllByAlcohol(alcohol);

        if (review.isEmpty()) {
            throw new InvalidateReviewException();
        }

        List<AlcoholReviewResponseDto> dto = new ArrayList();;

        for (int i=0; i<review.size(); i++) {
            String user = review.get(i).getUser().getUsername();
            String content = review.get(i).getReview();
            LocalDateTime date = review.get(i).getModifiedDate();

            dto.add(new AlcoholReviewResponseDto(id, user, content, date));
        }

        return dto;
    }
}

package com.alevel.backend.controller;

import com.alevel.backend.controller.dto.AlcoholReviewDto;
import com.alevel.backend.controller.dto.SaveAlcoholReviewDto;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * 한 줄 리뷰 작성
     */
    @PostMapping(value = "/alcohols/{id}/review")
    public ResultResponse saveReview(@PathVariable("id") Long id, @RequestBody AlcoholReviewDto dto){
        SaveAlcoholReviewDto saveAlcoholReviewDto = new SaveAlcoholReviewDto(id, dto.getUserid(), dto.getContent());
        reviewService.saveReview(saveAlcoholReviewDto);
        return ResultResponse.success();
    }
}

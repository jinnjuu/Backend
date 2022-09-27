package com.alevel.backend.controller;

import com.alevel.backend.controller.dto.AlcoholReviewRequestDto;
import com.alevel.backend.controller.dto.AlcoholReviewSaveDto;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResultResponse saveReview(@PathVariable("id") Long id, @RequestBody AlcoholReviewRequestDto request){
        AlcoholReviewSaveDto dto = new AlcoholReviewSaveDto(id, request.getUserid(), request.getContent());
        reviewService.saveReview(dto);
        return ResultResponse.success();
    }

    /**
     * 한 줄 리뷰 조회
     * 사용: AlcoholController.getAlcoholDetailPage
     */
    @GetMapping(value = "/alcohols/{id}/review")
    public ResultResponse getReview(@PathVariable("id") Long id){
        return ResultResponse.success(reviewService.getReview(id));
    }
}

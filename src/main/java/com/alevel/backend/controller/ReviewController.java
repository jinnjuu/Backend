package com.alevel.backend.controller;

import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.dto.AlcoholReviewSaveDto;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.dto.ContentRequestDto;
import com.alevel.backend.jwt.CustomUserDetails;
import com.alevel.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ReviewController {

    @Autowired
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * 한 줄 리뷰 작성
     */
    @PostMapping(value = "/alcohols/{id}/review")
    public ResultResponse saveReview(
            @PathVariable("id") Long id,
            @RequestBody ContentRequestDto request,
            @AuthenticationPrincipal CustomUserDetails user
    ){
        AlcoholReviewSaveDto dto = new AlcoholReviewSaveDto(id, user.getId(), request.getContent());
        reviewService.saveReview(dto);
        return ResultResponse.success();
    }

    /**
     * 한 줄 리뷰 조회 (전체)
     * 사용: AlcoholController.getAlcoholDetailPage
     */
    @GetMapping(value = "/alcohols/{id}/review")
    public ResultResponse getReviews(@PathVariable("id") Long id){
        return ResultResponse.success(reviewService.getReview(id));
    }

    /**
     * 한 줄 리뷰 삭제
     */
    @DeleteMapping(value = "/alcohols/{id}/review/{review-id}")
    public ResultResponse deleteReview(@PathVariable("id") Long id, @PathVariable("review-id") Long reviewId){
        try {
            reviewService.deleteReviewById(reviewId);
            return ResultResponse.success();
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.NOT_FOUND, ResponseMessage.INVALIDATED_REVIEW);
        }
    }
}

package com.alevel.backend.controller;

import com.alevel.backend.controller.dto.AlcoholResponseDto;
import com.alevel.backend.controller.dto.AlcoholReviewResponseDto;
import com.alevel.backend.controller.dto.PostResponseDto;
import com.alevel.backend.controller.dto.AlcoholResponseDto;
import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.service.AlcoholService;
import com.alevel.backend.service.PostService;
import com.alevel.backend.service.PreferenceService;
import com.alevel.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AlcoholController {

    @Autowired
    private AlcoholService alcoholService;
    @Autowired
    private ReviewService reviewService;
    private PostService postService;
    private PreferenceService preferenceService;

    @Autowired
    public AlcoholController(AlcoholService alcoholService, ReviewService reviewService, PostService postService, PreferenceService preferenceService) {
        this.alcoholService = alcoholService;
        this.reviewService = reviewService;
        this.postService = postService;
        this.preferenceService = preferenceService;
    }

    /**
     * 술 전체 조회
     */
    @GetMapping(value = "/alcohols")
    public ResultResponse getAlcohol(
            String type, String category,
            @PageableDefault(size = 6, sort = "hit", direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            Page<AlcoholResponseDto> alcohol = alcoholService.findAllAlcohol(type, category, pageable);
            System.out.println("alcohol:" + alcohol);
            return ResultResponse.success(alcohol.getContent());
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.BAD_REQUEST, ResponseMessage.FAIL);
        }
    }


    /**
     *
     * 술 상세 페이지 조회 - 술 상세정보, 한줄리뷰, 게시글, 추천게시글
     */
    @GetMapping(value = "/alcohols/{id}")
    public ResultResponse getAlcoholDetailPage(@PathVariable("id") Long id, Long userid) {
        try {
            AlcoholResponseDto alcohol = alcoholService.findAlcoholDetail(id);
            List<AlcoholReviewResponseDto> review = reviewService.getReview(id);
            List<PostResponseDto> post = postService.findByAlcoholName(alcohol.getName());
            List<PostResponseDto> recommendationPost = preferenceService.findRecommendationPost(userid);

            Map<String, Object> data = new HashMap<String, Object>();
            data.put("alcohol", alcohol);
            data.put("review", review);
            data.put("post", post);
            data.put("recommendationPost", recommendationPost);

            return ResultResponse.success(data);
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.BAD_REQUEST, ResponseMessage.FAIL);
        }
    }

    /**
     *
     * 술 상세 조회
     * 사용: AlcoholController.getAlcoholDetailPage
     */
    @GetMapping(value = "/alcohols/{id}/detail")
    public ResultResponse getAlcoholDetail(@PathVariable("id") Long id) {
        try {
            AlcoholResponseDto alcohol = alcoholService.findAlcoholDetail(id);
            return ResultResponse.success(alcohol);
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.BAD_REQUEST, ResponseMessage.FAIL);
        }
    }

    /**
     *
     * 술 스크랩
     */
    @PostMapping(value = "/alcohols/{id}/scrap")
    public ResultResponse scrapAlcohol(@PathVariable("id") Long alcoholid, Long userid) {
        alcoholService.scrapAlcohol(userid, alcoholid);
        return ResultResponse.success();
    }

}

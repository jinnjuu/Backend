package com.alevel.backend.controller;

import com.alevel.backend.controller.dto.PostResponseDto;
import com.alevel.backend.domain.preference.Preference;
import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.service.PostService;
import com.alevel.backend.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PreferenceController {

    private final PreferenceService preferenceService;
    private final PostService postService;

    @Autowired
    public PreferenceController(PreferenceService preferenceService, PostService postService) {
        this.preferenceService = preferenceService;
        this.postService = postService;
    }

    /**
     * 술 취향 등록
     */
    @PostMapping(value = "/users/preference")
    public ResultResponse savePreference(@RequestBody Preference preference) {
        try {
            String recommendation = preferenceService.getRecommendationId(preference);
            preference.setRecommendation(recommendation);
            preferenceService.insert(preference);
            return ResultResponse.success();
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.BAD_REQUEST, ResponseMessage.FAIL);
        }
    }

    /**
     * 술 추천
     */
    @GetMapping(value = "/recommendations/alcohol")
    public ResultResponse recommendAlcohol(Long userid, String type) {
        try {
            return ResultResponse.success(preferenceService.findRecommendationAlcohol(userid, type));
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.NOT_FOUND, ResponseMessage.INVALIDATED_ALCOHOL);
        }
    }

    /**
     *
     * 유저 취향과 비슷한 게시글 추천
     * 사용: AlcoholController.getAlcoholDetailPage
     */
    @GetMapping(value = "/recommendations/post")
    public ResultResponse recommendPost(Long userid) {
        try {
            List<PostResponseDto> recommendationPost = preferenceService.findRecommendationPost(userid);
            return ResultResponse.success(recommendationPost);
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.NOT_FOUND, ResponseMessage.INVALIDATED_POST);
        }
    }
}

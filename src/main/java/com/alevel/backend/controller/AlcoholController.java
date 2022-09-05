package com.alevel.backend.controller;

import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.service.AlcoholService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlcoholController {

    @Autowired
    private AlcoholService alcoholService;

    @Autowired
    public AlcoholController(AlcoholService alcoholService) {
        this.alcoholService = alcoholService;
    }

    /**
     * 술 전체 조회
     */
    @GetMapping(value = "/alcohols")
    public ResultResponse getAlcohol(
            String type, String category,
            @PageableDefault(size = 6, sort = "hit", direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            return ResultResponse.success(alcoholService.findAllAlcohol(type, category, pageable));
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

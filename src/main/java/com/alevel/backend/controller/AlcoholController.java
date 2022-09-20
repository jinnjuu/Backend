package com.alevel.backend.controller;

import com.alevel.backend.domain.response.DefaultResponse;
import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.service.AlcoholService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping(value = "/alcohol")
    public ResponseEntity getAlcohol(
            String type, String category,
            @PageableDefault(size = 6, sort = "hit", direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            return new ResponseEntity(alcoholService.findAllAlcohol(type, category, pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new DefaultResponse(StatusCode.BAD_REQUEST, ResponseMessage.FAIL, type), HttpStatus.BAD_REQUEST);
        }
    }



}

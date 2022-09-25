package com.alevel.backend.controller;


import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.service.AlcoholSearchService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlcoholSearchController {
    private final AlcoholSearchService alcoholSearchService;

    public AlcoholSearchController(AlcoholSearchService alcoholSearchService) {
        this.alcoholSearchService = alcoholSearchService;
    }

    @GetMapping("/alcohol/search")
    public List<Alcohol> search(String keyword) {
        List<Alcohol> searchList = alcoholSearchService.searchKeyword(keyword);
        return searchList;
    }

}

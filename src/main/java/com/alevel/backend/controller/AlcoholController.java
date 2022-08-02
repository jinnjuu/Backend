package com.alevel.backend.controller;

import com.alevel.backend.service.AlcoholService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlcoholController {

    @Autowired
    private AlcoholService alcoholService;

    @Autowired
    public AlcoholController(AlcoholService alcoholService) {
        this.alcoholService = alcoholService;
    }

}

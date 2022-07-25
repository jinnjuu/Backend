package com.alevel.backend.controller;

import com.alevel.backend.domain.Alchol;
import com.alevel.backend.domain.Preference;
import com.alevel.backend.domain.RecommendRepository;
import com.alevel.backend.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecommendController {
    @GetMapping("/user/{id}/prefer/alchol")
    public ResponseEntity searchalchol(@RequestBody Long user_id){
        return new ResponseEntity(RecommendService.search(user_id), HttpStatus.OK);
}


}
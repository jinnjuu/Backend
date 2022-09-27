package com.alevel.backend.controller;

import com.alevel.backend.controller.dto.MyPagePostResponseDto;
import com.alevel.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/users/{id}/post")
    public MyPagePostResponseDto findByUserId (@PathVariable Long id){
        return postService.findByUserId(id);
    }
}

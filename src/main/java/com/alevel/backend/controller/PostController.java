package com.alevel.backend.controller;

import com.alevel.backend.controller.dto.PostResponseDto;
import com.alevel.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/user/{id}/post")
    public PostResponseDto findByUserId (@PathVariable Long user_id){
        return postService.findByUserId(user_id);
    }
}

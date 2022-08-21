package com.alevel.backend.controller;

import com.alevel.backend.controller.dto.MypageCommentResponseDto;
import com.alevel.backend.service.MypageCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MypageCommentController {
    private final MypageCommentService mypageCommentService;

    @GetMapping("/users/{id}/comment")
    public MypageCommentResponseDto findByUserId(@PathVariable Long id){
        return mypageCommentService.findByUserId(id);
    }
}

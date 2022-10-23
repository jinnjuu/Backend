package com.alevel.backend.controller;

import com.alevel.backend.controller.dto.*;
import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.domain.response.StatusCode;
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

    /**
     *
     * 게시글 상세 페이지 - 게시글 상세정보, 댓글
     */
    @GetMapping("/posts/{id}")
    public ResultResponse findPostById (@PathVariable Long id){
        try {
            PostDetailResponseDto post = postService.findPostAndCommentsById(id);
            return ResultResponse.success(post);
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.NOT_FOUND, ResponseMessage.INVALIDATED_POST);
        }
    }
}

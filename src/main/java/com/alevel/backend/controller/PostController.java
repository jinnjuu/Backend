package com.alevel.backend.controller;

import com.alevel.backend.controller.dto.*;
import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


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
            PostCommentsDetailResponseDto post = postService.findPostAndCommentsById(id);
            return ResultResponse.success(post);
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.NOT_FOUND, ResponseMessage.INVALIDATED_POST);
        }
    }

    /**
     *
     * 게시글 조회 (피드)
     */
    @GetMapping("/posts")
    public ResultResponse findPosts (){
        try {
            return ResultResponse.success(postService.findPosts());
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.NOT_FOUND, ResponseMessage.INVALIDATED_POST);
        }
    }

    /**
     *
     * 게시글 삭제
     * status 0: 삭제
     */
    @PutMapping("/posts/{id}")
    public ResultResponse deletePostById (@PathVariable Long id){
        try {
            return ResultResponse.success(postService.deletePostById(id));
        } catch (Exception e) {
            return ResultResponse.fail(StatusCode.NOT_FOUND, ResponseMessage.INVALIDATED_POST);
        }
    }

}

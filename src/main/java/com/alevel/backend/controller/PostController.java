package com.alevel.backend.controller;

import com.alevel.backend.domain.response.ResponseMessage;
import com.alevel.backend.domain.response.ResultResponse;
import com.alevel.backend.domain.response.StatusCode;
import com.alevel.backend.dto.MyPagePostResponseDto;
import com.alevel.backend.dto.PostCommentsDetailResponseDto;
import com.alevel.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class PostController {

    private final PostService postService;

    @GetMapping("/users/{id}/post")
    public MyPagePostResponseDto findByUserId (@PathVariable Long id){
        return postService.findByUserId(id);
    }

    /**
     *
     * 게시글 상세 페이지 - 게시글 상세정보, 좋아요여부, 스크랩여부, 댓글
     */
    @GetMapping("/posts/{id}")
    public ResultResponse findPostById (@PathVariable Long id, Long userid){
        try {
            PostCommentsDetailResponseDto post = postService.findPostAndCommentsById(id, userid);
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

    /**
     *
     * 게시글 좋아요 여부
     */
    @GetMapping(value = "/posts/{id}/like")
    public ResultResponse likePostCheck(@PathVariable("id") Long postid, Long userid) {
        return ResultResponse.success(postService.CheckLike(userid, postid));
    }

    /**
     *
     * 게시글 스크랩 여부
     */
    @GetMapping(value = "/posts/{id}/scrap")
    public ResultResponse scrapPostCheck(@PathVariable("id") Long postid, Long userid) {
        return ResultResponse.success(postService.CheckScrap(userid, postid));
    }

}

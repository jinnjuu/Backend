package com.alevel.backend.service;

import com.alevel.backend.controller.dto.MypageTab.*;
import com.alevel.backend.domain.comment.Comment;
import com.alevel.backend.domain.comment.CommentRepository;
import com.alevel.backend.domain.post.Post;
import com.alevel.backend.domain.post.PostRepository;
import com.alevel.backend.domain.scrapalcohol.ScrapAlcohol;
import com.alevel.backend.domain.scrapalcohol.ScrapAlcoholRepository;
import com.alevel.backend.domain.scrappost.ScrapPostRepository;
import com.alevel.backend.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MypageTabService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ScrapAlcoholRepository scrapAlcoholRepository;
    private final ScrapPostRepository scrapPostRepository;
    private final UserRepository userRepository;
    private final int count;

    @Transactional
    public MypageTabPostDto findByPostUserId(Long userId){
        Post entity= postRepository.findByUserId(userId)
                .orElseThrow(()
                -> new IllegalArgumentException("작성한 글이 없습니다. id="+userId));

        return new MypageTabPostDto(entity);
    }
    @Transactional
    public MypageTabCommentDto findByCommentUserId(Long id){
        Comment CommentEntity=commentRepository.findByUserId(id).orElseThrow(()
                -> new IllegalArgumentException("작성한 댓글이 없습니다. id="+id));
        return new MypageTabCommentDto(CommentEntity);
    }
//    @Transactional
//    public MypageTabNameDto findByUsername(Long id){
//        User UserEntity=userRepository.findById(id).orElseThrow(()
//                ->new IllegalArgumentException("일치하는 사용자가 없습니다. username="+username));
//        User UserNameEntity=UserEntity.getUsername()
//        return new MypageTabNameDto(UserEntity);
//    }
    @Transactional
    public MypageTabScrapAlcoholDto findByScrapAlcoholUserId(Long id){
        ScrapAlcohol entity=scrapAlcoholRepository.findByUserId(id).orElseThrow(()
                -> new IllegalArgumentException("스크랩한 술이 없습니다. id="+id));
        return new MypageTabScrapAlcoholDto(entity);
    }
//
//    각 repo에서 count column만 select -> interface 만들어야 됨 search 하기
//    @Transactional
//    public int countScrapAlcohol(Long id){
////        int count=scrapAlcoholRepository.(count만 셀렉해오는 method필요 -> repo에 query작성)
////    return count;
//    }


//    @Transactional
//    public MypageTabScrapAlcoholDto tmp(Long id){
//        int a= countScrapAlcohol(id)
//    return dto 매개변수로 nickname, count 한것들 다 담아 보냄 기존 dto 지우고 하나로 통합한거 만들기
//    }


//    @Transactional
//    public MypageTabScrapPostDto findByScrapPostId(Long postId){
//        ScrapPost entity=scrapPostRepository.findByScrapPostId(postId);
//        return new MypageTabScrapPostDto(entity);
//    }

}

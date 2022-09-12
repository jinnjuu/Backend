package com.alevel.backend.service;


import com.alevel.backend.controller.dto.MypageTabDto;
import com.alevel.backend.domain.comment.CommentRepository;
import com.alevel.backend.domain.post.Post;
import com.alevel.backend.domain.post.PostRepository;
import com.alevel.backend.domain.scrapalcohol.ScrapAlcoholRepository;
import com.alevel.backend.domain.scrappost.ScrapPostRepository;
import com.alevel.backend.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MypageTabService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ScrapAlcoholRepository scrapAlcoholRepository;
    private final ScrapPostRepository scrapPostRepository;
    private final UserRepository userRepository;
    private Integer myPost, myComment,myScrapAlcohol,myScrapPost;
//    private String myUserName;



@Transactional
public MypageTabDto countMyPost(Long id){
    myPost=postRepository.myPostCount(id);
    myComment=commentRepository.myCommentCount(id);
    myScrapAlcohol=scrapAlcoholRepository.myScrapAlcoholCount(id);
    myScrapPost=scrapPostRepository.myScrapPostCount(id);
//    myUserName=userRepository.myUserNameReturn(id);
    return new MypageTabDto(myPost,myComment,myScrapAlcohol,myScrapPost);
}




}

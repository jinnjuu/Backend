package com.alevel.backend.service;

import com.alevel.backend.controller.dto.PostResponseDto;
import com.alevel.backend.domain.post.Post;
import com.alevel.backend.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;


    @Transactional
    public PostResponseDto findByUserId(Long userId){
        Post entity= postRepository.findById(userId).orElseThrow(()
        -> new IllegalArgumentException("작성한 게시글이 없습니다. user id="+userId));
        return new PostResponseDto(entity);
    }
}

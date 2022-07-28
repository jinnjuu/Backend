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


    public PostResponseDto findByUserId(Long user_id){
        Post entity= postRepository.findById(user_id).orElseThrow(()
        -> new IllegalArgumentException("작성한 게시글이 없습니다. user id="+user_id));
        return new PostResponseDto(entity);
    }
}

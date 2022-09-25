package com.alevel.backend.service;

import com.alevel.backend.controller.dto.MyPagePostResponseDto;
import com.alevel.backend.controller.dto.PostResponseDto;
import com.alevel.backend.domain.post.Post;
import com.alevel.backend.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;


    @Transactional
    public MyPagePostResponseDto findByUserId(Long id){
        Post entity= postRepository.findByUserId(id).orElseThrow(()
        -> new IllegalArgumentException("작성한 게시글이 없습니다. id="+id));
        return new MyPagePostResponseDto(entity);
    }

    public List<PostResponseDto> findByAlcoholName(String name){
        List<Post> post = postRepository.findByAlcoholNameContaining(name);

        if (post.isEmpty()) {
            //throw new InvalidatePostException();
            return null;
        }

        List<PostResponseDto> dto = new ArrayList();;

        for (int i=0; i<post.size(); i++) {
            Long id = post.get(i).getId();
            String title = post.get(i).getTitle();
            String content = post.get(i).getContent();
            String image = post.get(i).getImage();
            Integer commentCount = post.get(i).getCommentCount();
            Integer scrapCount = post.get(i).getScrapCount();
            Integer likeCount = post.get(i).getLikeCount();

            dto.add(new PostResponseDto(id, title, content, image, commentCount, scrapCount, likeCount));
        }

        return dto;
    }
}

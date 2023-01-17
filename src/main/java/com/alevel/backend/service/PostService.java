package com.alevel.backend.service;

import com.alevel.backend.domain.likepost.LikePostRepository;
import com.alevel.backend.domain.post.Post;
import com.alevel.backend.domain.post.PostRepository;
import com.alevel.backend.domain.scrappost.ScrapPostRepository;
import com.alevel.backend.domain.user.User;
import com.alevel.backend.dto.*;
import com.alevel.backend.exception.InvalidatePostException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentService commentService;
    private final UserService userService;
    private final LikePostRepository likePostRepository;
    private final ScrapPostRepository scrapPostRepository;

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

        List<PostResponseDto> dto = new ArrayList();

        for (Post value : post) {
            Long id = value.getId();
            String title = value.getTitle();
            String content = value.getContent();
            String image = value.getImage();
            Integer commentCount = value.getCommentCount();
            Integer scrapCount = value.getScrapCount();
            Integer likeCount = value.getLikeCount();

            dto.add(new PostResponseDto(id, title, content, image, commentCount, scrapCount, likeCount));
        }

        return dto;
    }

    public List<PostResponseDto> findRecommendationTopPost(){

        Sort sort = Sort.by(
                Sort.Order.desc("hit"),
                Sort.Order.desc("likeCount"),
                Sort.Order.desc("scrapCount")
        );

        List<Post> post = postRepository.findAll(sort);

        if (post.isEmpty()) {
            //throw new InvalidatePostException();
            return null;
        }

        List<PostResponseDto> dto = new ArrayList();

        for (Post value : post) {
            Long id = value.getId();
            String title = value.getTitle();
            String content = value.getContent();
            String image = value.getImage();
            Integer commentCount = value.getCommentCount();
            Integer scrapCount = value.getScrapCount();
            Integer likeCount = value.getLikeCount();

            dto.add(new PostResponseDto(id, title, content, image, commentCount, scrapCount, likeCount));
        }

        return dto;
    }

    public PostCommentsDetailResponseDto findPostAndCommentsById(Long id, Long userid) {
        Post post = postRepository.findByIdAndStatusTrue(id).orElseThrow(
                () -> new InvalidatePostException()
        );
        List<CommentResponseDto> comments = commentService.findCommentseByPost(post);
        Boolean like = CheckLike(userid, id);
        Boolean scrap = CheckScrap(userid, id);
        return new PostCommentsDetailResponseDto(post, like, scrap, comments);
    }

    public List<PostDetailResponseDto> findPosts() {
        return postRepository.findByStatusTrue()
                .stream().map(PostDetailResponseDto::new).collect(Collectors.toList());
    }

    public Long deletePostById(Long id) {
        Post post = postRepository.findByIdAndStatusTrue(id).orElseThrow(
                () -> new InvalidatePostException()
        );
        post.setStatus(false);
        return postRepository.save(post).getId();
    }

    public boolean CheckLike(Long userId, Long postId) {
        User user = userService.findById(userId);
        Post post = findById(postId);
        return likePostRepository.findByUserAndPost(user, post).isPresent();
    }

    public boolean CheckScrap(Long userId, Long postId) {
        User user = userService.findById(userId);
        Post post = findById(postId);
        return scrapPostRepository.findByUserAndPost(user, post).isPresent();
    }

    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new InvalidatePostException());
    }
}

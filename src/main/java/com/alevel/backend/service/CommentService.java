package com.alevel.backend.service;

import com.alevel.backend.controller.dto.CommentResponseDto;
import com.alevel.backend.domain.comment.CommentRepository;
import com.alevel.backend.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public List<CommentResponseDto> findCommentseByPost(Post post){
        List<CommentResponseDto> comments = commentRepository.findUserAndContentAndModifiedDateByPost(post);
        return comments.isEmpty() ? null : comments;
    }
}

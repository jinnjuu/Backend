package com.alevel.backend.service;

import com.alevel.backend.dto.MypageCommentResponseDto;
import com.alevel.backend.domain.comment.Comment;
import com.alevel.backend.domain.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MypageCommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public MypageCommentResponseDto findByUserId(Long id){
        Comment entity = commentRepository.findByUserId(id).orElseThrow(()
                -> new IllegalArgumentException("작성한 댓글이 없습니다. id="+id));
        return new MypageCommentResponseDto(entity);
    }
}

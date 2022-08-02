package com.alevel.backend.controller;

import com.alevel.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private  final CommentService commentService;
}

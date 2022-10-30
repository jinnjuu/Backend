package com.alevel.backend.controller;

import com.alevel.backend.dto.MypageTabDto;
import com.alevel.backend.service.MypageTabService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MypageTabController {
    private final MypageTabService mypageTabService;

    @GetMapping("/mypage/{id}")
    public MypageTabDto findByUserId(@PathVariable Long id){
        return mypageTabService.countMyPost(id);
    }
}

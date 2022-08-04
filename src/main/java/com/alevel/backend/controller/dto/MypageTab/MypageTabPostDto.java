package com.alevel.backend.controller.dto.MypageTab;

import com.alevel.backend.domain.post.Post;
import lombok.Getter;

@Getter
public class MypageTabPostDto {

    private Integer MyPostCount;

    public MypageTabPostDto(Post entity){
        this.MyPostCount=entity.getMyPostCount();
    }


}

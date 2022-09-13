package com.alevel.backend.controller.dto;

import com.alevel.backend.domain.post.Post;
import lombok.Getter;

@Getter
public class MypageTabDto {

    private int MyPostCount;
    private int MyCommentCount;
    private int MyScrapAlcoholCount;
    private int MyScrapPostCount;
//    private String MyUserNameReturn;

//    //post의 postcount를 어케 받아오고 아는지.
//    public int myPostCountDto(Post entity){
//        return PostCount;
//    }


    public MypageTabDto(Integer myPost, Integer myComment, Integer myScrapAlcohol, Integer myScrapPost)
        {this.MyPostCount=myPost;
        this.MyCommentCount=myComment;
        this.MyScrapPostCount=myScrapPost;
        this.MyScrapAlcoholCount=myScrapAlcohol;
//        this.MyUserNameReturn=myUserName;
        }

}

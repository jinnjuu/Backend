package com.alevel.backend.controller.dto;

import com.alevel.backend.domain.post.Post;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostCommentsDetailResponseDto {

    private Long id;
    private String username;
    private String title;
    private String content;
    private String image;
    private Long hit;
    private Integer commentCount;
    private Integer scrapCount;
    private Integer likeCount;
    private String alcoholName;
    private String flavor;
    private BigDecimal volume;
    private String price;
    private Long body;
    private Long sugar;
    private LocalDateTime modifiedDate;
    private Boolean like;
    private Boolean scrap;
    private List<CommentResponseDto> comments;

    public PostCommentsDetailResponseDto(Post post, Boolean like, Boolean scrap, List<CommentResponseDto> dto){
        this.id = post.getId();
        this.username = post.getUser().getUsername();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.image = post.getImage();
        this.hit = post.getHit();
        this.commentCount = post.getCommentCount();
        this.scrapCount = post.getScrapCount();
        this.likeCount = post.getLikeCount();
        this.modifiedDate = post.getModifiedDate();

        this.alcoholName = post.getAlcoholName();
        this.flavor = post.getFlavor();
        this.volume = post.getVolume();
        this.price = post.getPrice();
        this.body = post.getBody();
        this.sugar = post.getSugar();

        this.like = like;
        this.scrap = scrap;

        this.comments = dto;
    }

}

package com.alevel.backend.dto;

import com.alevel.backend.domain.post.Post;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostCommentsDetailResponseDto {

    private final Long id;
    private final String username;
    private final String title;
    private final String content;
    private final String image;
    private final Long hit;
    private final Integer commentCount;
    private final Integer scrapCount;
    private final Integer likeCount;
    private final String alcoholName;
    private final String flavor;
    private final BigDecimal volume;
    private final String price;
    private final Long body;
    private final Long sugar;
    private final LocalDateTime modifiedDate;
    private final Boolean like;
    private final Boolean scrap;
    private final List<CommentResponseDto> comments;

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

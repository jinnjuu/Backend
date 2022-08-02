package com.alevel.backend.domain.likepost;

import com.alevel.backend.domain.post.Post;
import com.alevel.backend.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class LikePost {
    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Long postId;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private Long userId;
}

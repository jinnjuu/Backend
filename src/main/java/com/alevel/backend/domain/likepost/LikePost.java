package com.alevel.backend.domain.likepost;

import com.alevel.backend.domain.post.Post;
import com.alevel.backend.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@DynamicInsert
@Table(name = "like_post")
@Entity
public class LikePost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
}

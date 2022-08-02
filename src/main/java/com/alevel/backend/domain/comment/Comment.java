package com.alevel.backend.domain.comment;

import com.alevel.backend.domain.BaseTimeEntity;
import com.alevel.backend.domain.post.Post;
import com.alevel.backend.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private Long userId;
    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Long postId;
    @Column(columnDefinition = "TEXT")
    private String content;
}

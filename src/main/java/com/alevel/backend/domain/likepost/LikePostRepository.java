package com.alevel.backend.domain.likepost;

import com.alevel.backend.domain.post.Post;
import com.alevel.backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikePostRepository extends JpaRepository<LikePost, Long> {

    Optional<LikePost> findByUserAndPost(User user, Post post);
}
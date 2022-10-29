package com.alevel.backend.domain.scrappost;

import com.alevel.backend.domain.post.Post;
import com.alevel.backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScrapPostRepository extends JpaRepository<ScrapPost, Long> {

    @Query(value="SELECT COUNT(*) FROM scrap_post sp WHERE sp.user_id=user_id", nativeQuery = true)
    Integer myScrapPostCount(Long id);

    Optional<ScrapPost> findByUserAndPost(User user, Post post);
}
package com.alevel.backend.domain.post;

import com.alevel.backend.domain.scrappost.ScrapPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {

    Optional<Post> findByUserId(Long id);

//부르면 쿼리 실행 ->서비스
    @Query(value = "SELECT COUNT(*) FROM post p WHERE p.user_id=user_id", nativeQuery = true)
    Integer myPostCount(Long id);


}


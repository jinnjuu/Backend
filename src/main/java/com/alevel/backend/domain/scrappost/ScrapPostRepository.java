package com.alevel.backend.domain.scrappost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrapPostRepository extends JpaRepository<ScrapPost, Long> {

//       ScrapPost findByScrapPostId(Long postId);
}
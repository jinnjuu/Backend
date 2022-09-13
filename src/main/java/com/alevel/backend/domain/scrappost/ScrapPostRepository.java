package com.alevel.backend.domain.scrappost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrapPostRepository extends JpaRepository<ScrapPost, Long> {

    @Query(value="SELECT COUNT(*) FROM scrap_post sp WHERE sp.user_id=user_id", nativeQuery = true)
    Integer myScrapPostCount(Long id);

}
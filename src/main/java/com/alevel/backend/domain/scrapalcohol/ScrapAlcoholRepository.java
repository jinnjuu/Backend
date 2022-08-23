package com.alevel.backend.domain.scrapalcohol;

import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScrapAlcoholRepository extends JpaRepository<ScrapAlcohol, Long> {
    @Query(value = "SELECT  COUNT(*) FROM scrap_alcohol sa WHERE sa.user_id=user_id", nativeQuery = true)
    Integer myScrapAlcoholCount(Long id);
}
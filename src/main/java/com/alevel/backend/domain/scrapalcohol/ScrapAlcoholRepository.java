package com.alevel.backend.domain.scrapalcohol;

import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScrapAlcoholRepository extends JpaRepository<ScrapAlcohol, Long> {

    Optional<ScrapAlcohol> findByUserId(Long id);

    void delete(ScrapAlcohol scrapAlcohol);

    Optional<ScrapAlcohol> findByUserAndAlcohol(User user, Alcohol alcohol);

    @Query(value = "SELECT  COUNT(*) FROM scrap_alcohol sa WHERE sa.user_id=user_id", nativeQuery = true)
    Integer myScrapAlcoholCount(Long id);

}
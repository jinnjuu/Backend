package com.alevel.backend.domain.scrapalcohol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScrapAlcoholRepository extends JpaRepository<ScrapAlcohol, Long> {
    Optional<ScrapAlcohol> findByUserId(Long id);
//    ScrapAlcohol findByUserId(Long id);

//    ScrapAlcohol findByAlcoholId(Long id);
}
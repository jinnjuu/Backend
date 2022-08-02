package com.alevel.backend.domain.scrapalcohol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrapAlcoholRepository extends JpaRepository<ScrapAlcohol, Long> {

}
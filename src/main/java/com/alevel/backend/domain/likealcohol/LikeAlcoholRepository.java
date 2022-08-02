package com.alevel.backend.domain.likealcohol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeAlcoholRepository extends JpaRepository<LikeAlcohol, Long> {

}
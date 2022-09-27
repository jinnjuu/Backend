package com.alevel.backend.domain.review;

import com.alevel.backend.domain.alcohol.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByAlcohol(Alcohol alcohol);

}
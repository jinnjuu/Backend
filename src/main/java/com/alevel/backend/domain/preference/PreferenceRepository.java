package com.alevel.backend.domain.preference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {
    @Override
    Preference save(Preference preference);

    @Query(value = "select p.recommendation from Preference p where p.userid = :userid")
    String findRecommendationByUserid(@Param("userid") Long userid);

    @Query(value = "select p from Preference p where p.userid = :userid")
    Preference findByUserId(@Param("userid") Long userid);

}

package com.alevel.backend.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendRepository extends JpaRepository<Preference,Long> {
   @Query("select user_id, value col from Preference cross apply string_split(col,',')")
   List<Preference> findByCol(String col);
}

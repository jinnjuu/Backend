package com.alevel.backend.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class RecommendRepository extends Preference {
    private final JPAQueryFactory queryFactory;


    public void searchType(String type){
        return queryFactory.selectFrom(Alchol)
                .where(Alchol.type.eq(Preference.type))
                .and(Preference.user_id=1);
    }

}
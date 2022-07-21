package com.alevel.backend.domain;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.alevel.backend.domain.QAlchol.alchol;
import static com.alevel.backend.domain.QPreference.preference;

@Repository
public class RecommendRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public RecommendRepositorySupport(JPAQueryFactory queryFactory){
        super(Alchol.class);
        this.queryFactory=queryFactory;
    }

    //type 검색 비교쿼리(1) - match 증가
    public JPAQuery<Tuple> findByType(String type){
        return queryFactory

                .select(alchol,
                        new CaseBuilder()
                                .when(alchol.type.eq(preference.type))
                                .then(alchol.match.add(1))
                                .otherwise(alchol.match.add(0))
                )
                .from(alchol,preference);

    }

    //type 검색 비교쿼리
//    public void findByType(){
//        List<Alchol> Type = queryFactory
//             .select(alchol)
//             .from(alchol,preference)
//             .where(alchol.type.eq(preference.type))
//             .fetch()
//
//
//    }
}

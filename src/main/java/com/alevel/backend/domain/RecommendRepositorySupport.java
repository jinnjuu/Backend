//package com.alevel.backend.domain;
//
//import com.querydsl.core.Tuple;
//import com.querydsl.core.types.dsl.CaseBuilder;
//import com.querydsl.jpa.impl.JPAQuery;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//import static com.alevel.backend.domain.QAlchol.alchol;
//import static com.alevel.backend.domain.QPreference.preference;
//
//@Repository
//public class RecommendRepositorySupport extends QuerydslRepositorySupport {
//    private final JPAQueryFactory queryFactory;
//
//    public RecommendRepositorySupport(JPAQueryFactory queryFactory){
//        super(Alchol.class);
//        this.queryFactory=queryFactory;
//    }
//
////    //type 검색 비교쿼리(1) - match 증가
////    public JPAQuery<Tuple> findByType(String type){
////        return queryFactory
////                .select(alchol,
////                        new CaseBuilder()
////                                .
////
////    }
//
////    type 검색 비교쿼리
//    public void findByType(){
//        List<Alchol> Type = queryFactory
//             .select(alchol)
//             .from(alchol,preference)
//             .where(alchol.type.eq(preference.type))
//             .fetch();}
//
//    public void findByVolume(){
//        List<Alchol> Volume = queryFactory
//                .select(alchol)
//                .from(alchol,preference)
//                .where(alchol.volume.eq(String.valueOf(preference.volume)))
//                .fetch();}
//
//    public void findBySugar(){
//        List<Alchol> Sugar = queryFactory
//                .select(alchol)
//                .from(alchol,preference)
//                .where(alchol.volume.eq(String.valueOf(preference.sugar)))
//                .fetch();}
//
//    public void findByFlavor(){
//        List<Alchol> Flavor = queryFactory
//                .select(alchol)
//                .from(alchol,preference)
//                .where(alchol.flavor.eq(preference.flavor))
//                .fetch();}
//
//    public void findByPrice() {
//        List<Alchol> Price = queryFactory
//                .select(alchol)
//                .from(alchol, preference)
//                .where(alchol.price.eq(preference.price))
//                .fetch();
//    }
//
//
//
//    //중복 id count
//    findByType()
//
//}

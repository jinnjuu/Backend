package com.alevel.backend.domain.alcohol;

import com.alevel.backend.controller.dto.AlcoholResponseDto;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class AlcoholRepositoryCustomImpl implements AlcoholRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public AlcoholRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    QAlcohol alcohol = QAlcohol.alcohol;

    @Override
    public Page<AlcoholResponseDto> findAllAlcohol(String type, String category, Pageable pageable) {

        JPAQuery<AlcoholResponseDto> query = queryFactory
                .select(Projections.constructor(AlcoholResponseDto.class,
                        alcohol.name, alcohol.volume, alcohol.size, alcohol.price, alcohol.image))
                .from(alcohol)
                .where(eqType(type),
                        eqCategory(category))
                .offset(pageable.getOffset()) // 페이지 번호
                .limit(pageable.getPageSize()); // 페이지 사이즈

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(alcohol.getType(), alcohol.getMetadata());
            query.orderBy(new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC,
                    pathBuilder.get(o.getProperty())));
        }

        List<AlcoholResponseDto> content = query.fetch();

        long totalCount = queryFactory.select(alcohol.count())
                .from(alcohol)
                .where(eqType(type),
                        eqCategory(category))
                .fetchOne();

        return new PageImpl<>(content, pageable, totalCount);
    }

    private BooleanExpression eqType(String type) {
        return StringUtils.isEmpty(type) ? null : alcohol.type.eq(type);
    }

    private BooleanExpression eqCategory(String category) {
        return StringUtils.isEmpty(category) ? null : alcohol.category.eq(category);
    }

}

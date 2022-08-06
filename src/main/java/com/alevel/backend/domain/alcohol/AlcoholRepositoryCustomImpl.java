package com.alevel.backend.domain.alcohol;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
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
    public Page<Alcohol> findAllAlcohol(String type, String category, Pageable pageable) {

        JPAQuery<Alcohol> query = queryFactory.
                selectFrom(alcohol)
                .where(eqType(type),
                        eqCategory(category))
                .offset(pageable.getOffset()) // 페이지 번호
                .limit(pageable.getPageSize()); // 페이지 사이즈

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(alcohol.getType(), alcohol.getMetadata());
            query.orderBy(new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC,
                    pathBuilder.get(o.getProperty())));
        }

        List<Alcohol> content = query.fetch();
        long total = content.size();

        return new PageImpl<>(content, pageable, total);
    }
    //            order by hit desc; -- 조회순
    //            order by volume asc; -- 낮은 도수 순
    //            order by price asc; -- 낮은 가격 순"

    private BooleanExpression eqType(String type) {
        return StringUtils.isEmpty(type) ? null : alcohol.type.eq(type);
    }

    private BooleanExpression eqCategory(String category) {
        return StringUtils.isEmpty(category) ? null : alcohol.category.eq(category);
    }

}

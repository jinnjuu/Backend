package com.alevel.backend.domain.review;

import com.alevel.backend.dto.AlcoholReviewResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import java.util.List;

public class ReviewRepositoryCustomImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ReviewRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    QReview review = QReview.review1;

    @Override
    public List<AlcoholReviewResponseDto> findAllByAlcoholId(Long id) {
        return queryFactory
                .select(
                        Projections.constructor(
                                AlcoholReviewResponseDto.class,
                                review.id,
                                review.alcohol.id,
                                review.user.username,
                                review.review,
                                review.createdDate
                        )
                )
                .from(review)
                .where(review.alcohol.id.eq(id))
                .fetch();
    }

}

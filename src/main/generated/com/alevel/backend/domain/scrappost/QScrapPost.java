package com.alevel.backend.domain.scrappost;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScrapPost is a Querydsl query type for ScrapPost
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScrapPost extends EntityPathBase<ScrapPost> {

    private static final long serialVersionUID = -440053886L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScrapPost scrapPost = new QScrapPost("scrapPost");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> myScrapPostCount = createNumber("myScrapPostCount", Integer.class);

    public final com.alevel.backend.domain.post.QPost post;

    public final com.alevel.backend.domain.user.QUser user;

    public QScrapPost(String variable) {
        this(ScrapPost.class, forVariable(variable), INITS);
    }

    public QScrapPost(Path<? extends ScrapPost> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScrapPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScrapPost(PathMetadata metadata, PathInits inits) {
        this(ScrapPost.class, metadata, inits);
    }

    public QScrapPost(Class<? extends ScrapPost> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new com.alevel.backend.domain.post.QPost(forProperty("post"), inits.get("post")) : null;
        this.user = inits.isInitialized("user") ? new com.alevel.backend.domain.user.QUser(forProperty("user")) : null;
    }

}


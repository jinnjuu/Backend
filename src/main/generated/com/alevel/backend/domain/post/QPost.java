package com.alevel.backend.domain.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = -31228900L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final StringPath alcoholName = createString("alcoholName");

    public final StringPath alcoholType = createString("alcoholType");

    public final NumberPath<Integer> body = createNumber("body", Integer.class);

    public final NumberPath<Integer> commentCount = createNumber("commentCount", Integer.class);

    public final StringPath content = createString("content");

    public final StringPath flavor = createString("flavor");

    public final NumberPath<Integer> hit = createNumber("hit", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final StringPath price = createString("price");

    public final NumberPath<Integer> sugar = createNumber("sugar", Integer.class);

    public final StringPath title = createString("title");

    public final com.alevel.backend.domain.user.QUser user;

    public final NumberPath<java.math.BigDecimal> volume = createNumber("volume", java.math.BigDecimal.class);

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.alevel.backend.domain.user.QUser(forProperty("user")) : null;
    }

}


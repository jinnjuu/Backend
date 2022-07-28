package com.alevel.backend.domain.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = -31228900L;

    public static final QPost post = new QPost("post");

    public final StringPath a_nm = createString("a_nm");

    public final StringPath a_type = createString("a_type");

    public final NumberPath<Integer> body = createNumber("body", Integer.class);

    public final StringPath content = createString("content");

    public final StringPath flavor = createString("flavor");

    public final NumberPath<Integer> hit = createNumber("hit", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final StringPath price = createString("price");

    public final NumberPath<Integer> sugar = createNumber("sugar", Integer.class);

    public final StringPath title = createString("title");

    public final NumberPath<Long> user_id = createNumber("user_id", Long.class);

    public final NumberPath<Integer> volume = createNumber("volume", Integer.class);

    public QPost(String variable) {
        super(Post.class, forVariable(variable));
    }

    public QPost(Path<? extends Post> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPost(PathMetadata metadata) {
        super(Post.class, metadata);
    }

}


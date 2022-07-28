package com.alevel.backend.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAlchol is a Querydsl query type for Alchol
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlchol extends EntityPathBase<Alchol> {

    private static final long serialVersionUID = 85374911L;

    public static final QAlchol alchol = new QAlchol("alchol");

    public final NumberPath<Integer> acidity = createNumber("acidity", Integer.class);

    public final NumberPath<Integer> body = createNumber("body", Integer.class);

    public final StringPath category = createString("category");

    public final StringPath flavor = createString("flavor");

    public final StringPath food = createString("food");

    public final NumberPath<Integer> hit = createNumber("hit", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath image = createString("image");

    public final NumberPath<Integer> match = createNumber("match", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath nation = createString("nation");

    public final StringPath price = createString("price");

    public final StringPath size = createString("size");

    public final NumberPath<Integer> sugar = createNumber("sugar", Integer.class);

    public final NumberPath<Integer> tannins = createNumber("tannins", Integer.class);

    public final StringPath type = createString("type");

    public final StringPath volume = createString("volume");

    public QAlchol(String variable) {
        super(Alchol.class, forVariable(variable));
    }

    public QAlchol(Path<? extends Alchol> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAlchol(PathMetadata metadata) {
        super(Alchol.class, metadata);
    }

}


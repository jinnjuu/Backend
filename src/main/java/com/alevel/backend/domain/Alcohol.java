package com.alevel.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Alcohol{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20,nullable = false)
    private String name;

    @Column(length = 10,nullable = false)
    private String type;  //주종

    @Column(length = 10,nullable = false)
    private String category;  //종류

    @Column(precision = 5,scale = 2)
    private BigDecimal volume;

    @Column(length = 20,nullable = false)
    private String flavor;

    @Column(length = 10,nullable = false)
    private String size;

    @Column(length =20,nullable = false)
    private String price;

    @Column(length = 50,nullable = false)
    private String food;

    @Column(length = 20,nullable = false)
    private String nation;

    @Column(length = 50,nullable = false)
    private String image;

//    private Integer match;

    private Integer hit; //조회수

    //와인
    private Integer body;

    private Integer sugar;

    private Integer tannins;

    private Integer acidity;

    @Builder
    public Alcohol(String name, String type, String category,BigDecimal volume, String flavor, String size, String price, String food, String nation, String image,int hit,int body,int sugar,int tannins,int acidity){
        this.name=name;
        this.type=type;
        this.category=category;
        this.volume=volume;
        this.flavor=flavor;
        this.size=size;
        this.price=price;
        this.food=food;
        this.nation=nation;
        this.image=image;
        this.hit=hit;
//        this.match=match;
        this.body=body;
        this.sugar=sugar;
        this.tannins=tannins;
        this.acidity=acidity;
    }

}
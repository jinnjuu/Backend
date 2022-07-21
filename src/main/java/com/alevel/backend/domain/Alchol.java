package com.alevel.backend.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Alchol{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String type;  //주종

    private String category;  //종류

    private String volume;

    private String flavor;

    private String size;

    private String price;

    private String food;

    private String nation;

    private String image;

    private int match;

    private int hit; //조회수

    //와인
    @Column()
    private int body;

    private int sugar;

    private int tannins;

    private int acidity;

    @Builder
    public Alchol(String name, String type, String category,String volume, String flavor, String size, String price, String food, String nation, String image, int match,int hit){
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
        this.match=match;
    }

}
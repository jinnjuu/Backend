package com.alevel.backend.domain.alcohol;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Data
public class Alcohol{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String type;  //주종

    @Column(length = 10, nullable = false)
    private String category;  //종류

    @Column(length = 5, nullable = false)
    private String volume;

    @Column(length = 100, nullable = false)
    private String flavor;

    @Column(length = 10, nullable = false)
    private String size;

    private Integer price;

    @Column(length = 100, nullable = false)
    private String food;

    @Column(length = 20, nullable = false)
    private String nation;

    @Column(length = 100, nullable = false)
    private String image;

    @Column(length = 200)
    private String info;

    private Integer hit; //조회수

    private Integer body;

    private Integer sugar;

    private Integer tannins;

    private Integer acidity;

    @Builder
    public Alcohol(String name, String type, String category, String volume, String flavor, String size, Integer price, String food, String nation, String image, String info, int hit, int body, int sugar, int tannins, int acidity) {
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
        this.info=info;
        this.hit=hit;
        this.body=body;
        this.sugar=sugar;
        this.tannins=tannins;
        this.acidity=acidity;
    }

}

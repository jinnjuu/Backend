package com.alevel.backend.domain.alcohol;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Data
public class Alcohol{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String type;  //주종

    private String category;  //종류

    private String volume;

    private String flavor;

    private String size;

    private Integer price;

    private String food;

    private String nation;

    private String image;

    private Long hit; //조회수

    private Integer body;

    private Integer sugar;

    private Integer tannins;

    private Integer acidity;

}
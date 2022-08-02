package com.alevel.backend.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Data
public class Preference {

    @Id
    private Long user_id;

    private String type;

    private int volume;

    private int sugar;

    private String flavor;

    private String price;

    @Builder
    public Preference(String type, int volume, int sugar,String flavor, String price){
        this.type=type;
        this.volume=volume;
        this.sugar=sugar;
        this.flavor=flavor;
        this.price=price;
    }


}

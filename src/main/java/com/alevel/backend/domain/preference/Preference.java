package com.alevel.backend.domain.preference;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Data
public class Preference {

    @Id
    @Column(name = "user_id")
    private Long userid;

    private String type;

    private int volume;

    private int sugar;

    private String flavor;

    private String price;

    private String recommendation;
    
    @Builder
    public Preference(Long user_id, String type, int volume, int sugar, String flavor, String price, String recommendation) {
        this.type=type;
        this.volume=volume;
        this.sugar=sugar;
        this.flavor=flavor;
        this.price=price;
	    this.recommendation=recommendation;
    }

}

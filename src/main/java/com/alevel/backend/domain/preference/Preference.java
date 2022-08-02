package com.alevel.backend.domain.preference;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    private String recommendation;
}

package com.alevel.backend.domain.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long user_id;

    private String title;

    private String content;

    private String image;

    private int hit;

    private String a_nm;

    private String a_type;

    private String flavor;

    private String price;

    private int volume;

    private int body;

    private int sugar;



}

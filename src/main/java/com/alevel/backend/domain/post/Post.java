package com.alevel.backend.domain.post;

import com.alevel.backend.domain.user.User;
import com.mysql.cj.protocol.ColumnDefinition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //fk
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id") //table의 column명
    private User user;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(columnDefinition="TEXT", nullable = false)
    private String content;

    @Column(length = 50)
    private String image;

    private int hit;

    @Column(length = 20)
    private String alcoholName;

    @Column(length = 10)
    private String alcoholType;

    @Column(length = 20)
    private String flavor;

    @Column(length=20)
    private String price;

    @Column(precision = 5, scale=2)
    private BigDecimal volume;

    private Integer body;

    private Integer sugar;

    @Formula("(select count(*) from comment c where c.post_id=id)")
    private Integer commentCount;


}

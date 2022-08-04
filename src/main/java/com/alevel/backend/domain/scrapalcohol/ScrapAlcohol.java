package com.alevel.backend.domain.scrapalcohol;

import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class ScrapAlcohol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = Alcohol.class)
    @JoinColumn(name = "alcohol_id")
    private Alcohol alcohol;

    @Formula("(SELECT  COUNT(*) FROM scrap_alcohol sa WHERE sa.user_id=user_id)")
    private Integer myScrapAlcoholCount;

}

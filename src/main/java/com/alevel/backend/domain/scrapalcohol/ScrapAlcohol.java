package com.alevel.backend.domain.scrapalcohol;

import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class ScrapAlcohol {
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private Long userId;
    @ManyToOne(targetEntity = Alcohol.class)
    @JoinColumn(name = "alcohol_id")
    private Long alcoholId;
}

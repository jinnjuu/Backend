package com.alevel.backend.domain.likealcohol;

import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class LikeAlcohol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = Alcohol.class)
    @JoinColumn(name = "alcohol_id")
    private Long alcoholId;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private Long userId;
}

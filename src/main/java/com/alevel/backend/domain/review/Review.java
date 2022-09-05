package com.alevel.backend.domain.review;

import com.alevel.backend.domain.BaseTimeEntity;
import com.alevel.backend.domain.alcohol.Alcohol;
import com.alevel.backend.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = Alcohol.class)
    @JoinColumn(name = "alcohol_id")
    private Alcohol alcohol;

    @Column(length = 100, nullable = false)
    private String review;

    @Builder
    public Review(User user, Alcohol alcohol, String review) {
        this.user = user;
        this.alcohol = alcohol;
        this.review = review;
    }
}

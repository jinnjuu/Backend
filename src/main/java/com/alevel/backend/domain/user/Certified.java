package com.alevel.backend.domain.user;

import com.alevel.backend.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Certified extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String email;

    @NotNull
    private String token;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(columnDefinition = "TINYINT", length = 1)
    private boolean expired = false;

    @Column(columnDefinition = "TINYINT", length = 1)
    private boolean verified = false;

    public void useToken(){
        expired = true;
    }
    public void verifiedSuccess(){ verified = true; }

    @Builder
    public Certified(String email, String token, LocalDateTime expirationDate) {
        this.email = email;
        this.token = token;
        this.expirationDate = expirationDate;
    }
}

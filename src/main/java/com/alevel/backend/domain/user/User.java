package com.alevel.backend.domain.user;

import com.alevel.backend.domain.BaseTimeEntity;
import com.alevel.backend.enums.Authority;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String username;

    @Column(columnDefinition = "TINYINT", length = 1)
    private boolean status = true;

    @Enumerated(EnumType.STRING)
    private Authority authorities;

}
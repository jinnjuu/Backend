package com.alevel.backend.domain.user;

import com.alevel.backend.domain.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Email
    @Column(nullable=false)
    private String email;
    
    @NotBlank
    private String password;

    @Column
    private String picture;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column
    private int status = 1;
    
    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}
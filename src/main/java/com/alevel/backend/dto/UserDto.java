package com.alevel.backend.dto;

import com.alevel.backend.enums.Authority;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDto {
    private String email;
    private String password;
    private String username;
    private Authority role;
}

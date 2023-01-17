package com.alevel.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {
    private Long id;
    private String token;
//    private String grantType;
//    private String accessToken;
//    private String refreshToken;
}

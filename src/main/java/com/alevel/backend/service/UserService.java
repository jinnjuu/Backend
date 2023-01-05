package com.alevel.backend.service;

import com.alevel.backend.dto.LoginDto;
import com.alevel.backend.dto.MypageAccountResponseDto;
import com.alevel.backend.domain.user.User;
import com.alevel.backend.domain.user.UserRepository;
import com.alevel.backend.dto.UserDto;
import com.alevel.backend.dto.TokenDto;
import com.alevel.backend.enums.Authority;
import com.alevel.backend.exception.*;
import com.alevel.backend.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(
            UserRepository userRepository,
            AuthenticationManagerBuilder authenticationManagerBuilder,
            TokenProvider tokenProvider
    ) {
        this.userRepository = userRepository;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.tokenProvider = tokenProvider;
    }

    @Transactional
    public TokenDto login(LoginDto dto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);
        Long id = (userRepository.findByEmail(dto.getEmail()).orElseThrow(InvalidateUserException::new)).getId();
        return new TokenDto(id, jwt);
    }

    public User signup(UserDto dto) {
        User user = User.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .username(dto.getUsername())
                .authorities(Authority.ROLE_USER)
                .status(true)
                .build();
        return userRepository.save(user);
    }

    public void validateDuplicateUsername(String username) {
        userRepository.findByUsername(username)
                .ifPresent(m -> {
                    throw new DuplicatedUserException();
                });
    }

    public void validateDuplicateEmail(String email) {
        userRepository.findByEmail(email)
                .ifPresent(m -> {
                    throw new DuplicatedEmailException();
                });
    }

    public User remove(Long id) {
        Optional<User> userWrapper = userRepository.findById(id);
        User user = userWrapper.get();
        user.setStatus(false);
        return userRepository.save(user);
    }

    public User updateUsername(Long id, String username) {
        User user = userRepository.getReferenceById(id);
        user.setUsername(username);
        return userRepository.save(user);
    }

    public User updatePassword(Long id, String password) {
        User user = userRepository.getReferenceById(id);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public MypageAccountResponseDto getAccount(Long id) {
        Optional<User> user = userRepository.findById(id);
        User entity = user.get();
        return new MypageAccountResponseDto(entity);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new InvalidateUserException());
    }
}

package com.alevel.backend.service;

import com.alevel.backend.dto.MypageAccountResponseDto;
import com.alevel.backend.domain.user.User;
import com.alevel.backend.domain.user.UserRepository;
import com.alevel.backend.dto.UserDto;
import com.alevel.backend.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(
            UserRepository userRepository,
            AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userRepository = userRepository;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public User signup(UserDto dto) {
        return userRepository.save(
                new User(
                    dto.getEmail(),
                    passwordEncoder.encode(dto.getPassword()),
                    dto.getUsername()
                ));
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
        User user = findById(id);
        user.setStatus(false);
        return userRepository.save(user);
    }

    public User updateUsername(Long id, String username) {
        User user = findById(id);
        user.setUsername(username);
        return userRepository.save(user);
    }

    public User updatePassword(Long id, String password) {
        User user = findById(id);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public MypageAccountResponseDto getAccount(Long id) {
        Optional<User> user = userRepository.findById(id);
        User entity = user.get();
        return new MypageAccountResponseDto(entity);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new InvalidateUserException());
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new InvalidateUserException());
    }

    public User findByUserName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new InvalidateUserException());
    }
}

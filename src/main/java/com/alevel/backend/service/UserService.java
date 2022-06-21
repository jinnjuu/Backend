package com.alevel.backend.service;

import com.alevel.backend.domain.user.User;
import com.alevel.backend.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signup(String email, String password, String username) {
        User user = new User();
        String encryptPassword = passwordEncoder.encode(password);
        user.setEmail(email);
        user.setPassword(encryptPassword);
        user.setUsername(username);
        userRepository.save(user);
        return user;
    }

    public void validateDuplicateUsername(String username) {
        userRepository.findByUsername(username)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public void validateDuplicateEmail(String email) {
        userRepository.findByEmail(email)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이메일입니다.");
                });
    }
}

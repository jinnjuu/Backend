package com.alevel.backend.service;

import com.alevel.backend.controller.dto.MypageAccountResponseDto;
import com.alevel.backend.domain.user.User;
import com.alevel.backend.domain.user.UserRepository;
import com.alevel.backend.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    String encryptPassword;

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(InvalidateUserException::new);
        if (user.getStatus() != 1) {
            throw new WithdrawnUserException();
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidatePasswordException();
        }
        return user;
    }

    public User signup(String email, String password, String username) {
        User user = new User();
        encryptPassword = passwordEncoder.encode(password);
        user.setEmail(email);
        user.setPassword(encryptPassword);
        user.setUsername(username);
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
        user.setStatus(0);
        return userRepository.save(user);
    }

    public User updateUsername(Long id, String username) {
        User user = userRepository.getReferenceById(id);
        user.setUsername(username);
        return userRepository.save(user);
    }

    public User updatePassword(Long id, String password) {
        User user = userRepository.getReferenceById(id);
        encryptPassword = passwordEncoder.encode(password);
        user.setPassword(encryptPassword);
        return userRepository.save(user);
    }

    public MypageAccountResponseDto getAccount(Long id) {
        Optional<User> user = userRepository.findById(id);
        User entity = user.get();
        return new MypageAccountResponseDto(entity);
    }
}

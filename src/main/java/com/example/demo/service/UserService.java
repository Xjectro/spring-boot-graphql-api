package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.TokenManager;
import com.example.demo.exception.GraphQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenManager tokenManager;

    public UserService(UserRepository userRepository, TokenManager tokenManager) {
        this.tokenManager = tokenManager;
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Transactional
    public boolean createUser(String username, String email, String password) {
        if (userRepository.existsByUsername(username)) {
            throw new GraphQLException("Username already exists");
        }
        if (userRepository.existsByEmail(email)) {
            throw new GraphQLException("Email already exists");
        }
        String encodedPassword = encryptPassword(password);
        User user = new User(username, email, encodedPassword);
        userRepository.save(user);
        return true;
    }

    @Transactional
    public User updateUser(User user, String username) {
        user.setUsername(username);
        return userRepository.save(user);
    }

    @Transactional
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public String authentication(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            throw new GraphQLException("Email not found");
        }
        if (decodePassword(password, user.getPassword())) {
            return tokenManager.generateToken(user.getId());
        } else {
            throw new GraphQLException("Invalid password");
        }
    }

    public boolean decodePassword(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }

    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }
}

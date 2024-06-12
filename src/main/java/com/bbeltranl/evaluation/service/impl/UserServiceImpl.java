package com.bbeltranl.evaluation.service.impl;

import com.bbeltranl.evaluation.model.User;
import com.bbeltranl.evaluation.service.UserService;
import com.bbeltranl.evaluation.dto.UserRequest;
import com.bbeltranl.evaluation.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final String jwtSecret = "secret";

    @Override
    public User registerUser(UserRequest userRequest) {
        Optional<User> userOp = userRepository.findByEmail(userRequest.getEmail());
        if (userOp.isPresent()) {
            throw new IllegalArgumentException("El correo ya registrado");
        } else {
            User user = new User();
            user.setId(UUID.randomUUID());
            user.setName(userRequest.getName());
            user.setCreated(new Date());
            user.setModified(new Date());
            user.setLastLogin(new Date());
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());
            user.setToken(generateToken(userRequest.getEmail()));
            user.setPhones(userRequest.getPhones());
            user.setActive(true);

            return userRepository.save(user);
        }
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    private String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day expiration
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}

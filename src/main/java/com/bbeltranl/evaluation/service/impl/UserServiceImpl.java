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

/**
 * Implementation of {@link UserService} that provides methods for user registration and listing.
 * <p>
 * This service class interacts with the {@link UserRepository} to perform CRUD operations on {@link User} entities.
 * It also generates JWT tokens for user authentication.
 * </p>
 *
 * @author bbeltranl
 * @version 1.0
 * @since 2024-06-13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final String jwtSecret = "secret";

    /**
     * Registers a new user based on the information provided in {@code userRequest}.
     * <p>
     * It checks if the user with the provided email already exists in the database.
     * If the user does not exist, a new {@link User} entity is created, saved in the database,
     * and returned. If the user already exists, an {@link IllegalArgumentException} is thrown.
     * </p>
     *
     * @param userRequest the request object containing user information to be registered.
     * @return the {@link User} entity that has been registered.
     * @throws IllegalArgumentException if a user with the same email already exists.
     */
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

    /**
     * Retrieves a list of all users from the database.
     *
     * @return a {@link List} of {@link User} entities.
     */
    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user based on the provided unique identifier (UUID).
     *
     * @param id The unique identifier of the user to retrieve.
     * @return The {@link User} object if found.
     */
    @Override
    public User getUserById(UUID id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuario no encontrado");
        } else {
            return userOpt.get();
        }
    }

    /**
     * Deletes a user based on the provided unique identifier (UUID).
     *
     * @param id The unique identifier of the user to be deleted.
     */
    @Override
    public void deleteUserById(UUID id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuario no encontrado");
        } else {
            userRepository.deleteById(id);
        }
    }

    /**
     * Updates a user's information based on the provided unique identifier (UUID) and the request data.
     *
     * @param id The unique identifier of the user to be updated.
     * @param userRequest The request object containing the fields to update in the user.
     * @return The updated {@link User} object after the changes have been saved.
     */
    @Override
    public User updateUser(UUID id, UserRequest userRequest) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuario no encontrado");
        } else {
            User user = userOpt.get();
            user.setId(id);
            if(userRequest.getName()!=null) user.setName(userRequest.getName());
            user.setModified(new Date());
            user.setLastLogin(new Date());
            if(userRequest.getEmail()!=null) user.setEmail(userRequest.getEmail());
            if(userRequest.getPassword()!=null) user.setPassword(userRequest.getPassword());
            if(userRequest.getPhones()!=null) user.setPhones(userRequest.getPhones());
            return userRepository.save(user);
        }
    }

    /**
     * Generates a JWT token based on the provided email.
     *
     * @param email the email for which the token is generated.
     * @return the generated JWT token as a {@link String}.
     */
    private String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day expiration
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}

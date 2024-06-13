package com.bbeltranl.evaluation.controller;

import com.bbeltranl.evaluation.dto.UserResponse;
import com.bbeltranl.evaluation.model.User;
import com.bbeltranl.evaluation.service.UserService;
import com.bbeltranl.evaluation.dto.UserRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController is a REST controller that handles all user-related operations.
 * <p>
 * This controller provides endpoints for creating, updating, retrieving, and
 * deleting users. It acts as an interface between the front-end client and
 * the back-end services, managing user data within the system.
 * </p>
 * <p>
 * The class uses annotations from the Spring Framework to define its
 * RESTful nature and handle HTTP requests.
 * </p>
 *
 * @author bbeltranl
 * @version 1.0
 * @since 2024-06-13
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Creates a new user with the provided details.
     *
     * @param request An object containing the user's details for creation.
     * @return A ResponseEntity containing the created user's details.
     */
    @PostMapping("/")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRequest request) {
        try {
            User registeredUser = userService.registerUser(request);

            UserResponse response = new UserResponse();
            response.setId(registeredUser.getId());
            response.setCreated(registeredUser.getCreated());
            response.setModified(registeredUser.getModified());
            response.setLastLogin(registeredUser.getLastLogin());
            response.setToken(registeredUser.getToken());
            response.setIsActive(registeredUser.isActive());
            return ResponseEntity.status(201).body(response);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(409).body("{\"mensaje\": \"" + e.getMessage() + "\"}");
        }
    }

    /**
     * Retrieves a list of all users.
     *
     * @return A ResponseEntity containing a list of all users.
     */
    @GetMapping("/all")
    public List<User> listAll() {
        return userService.listAll();
    }
}
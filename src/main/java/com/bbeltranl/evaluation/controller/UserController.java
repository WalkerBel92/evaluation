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
import java.util.UUID;

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
     * @return {@link ResponseEntity} containing the user created,
     *      or a JSON-formatted error message with a 409 status code if exists some problem.
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
    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.listAll();
        return ResponseEntity.ok(users);
    }

    /**
     * Endpoint to retrieve a user by their unique identifier (UUID).
     *
     * @param id The unique identifier of the user to retrieve.
     * @return {@link ResponseEntity} containing the requested user if found,
     *         or a JSON-formatted error message with a 404 status code if the user is not found.
     *
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable UUID id) {
        try {
            User user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("{\"mensaje\": \"" + e.getMessage() + "\"}");
        }
    }

    /**
     * Endpoint to delete a user by their unique identifier (UUID).
     *
     * @param id The unique identifier of the user to be deleted.
     * @return {@link ResponseEntity} with a status of 204 No Content if the deletion is successful,
     *         or a JSON-formatted error message with a 404 status code if the user is not found.
     *
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        try {
            userService.deleteUserById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("{\"mensaje\": \"" + e.getMessage() + "\"}");
        }
    }

    /**
     * Endpoint to partially update a user by their unique identifier (UUID).
     *
     * @param id The unique identifier of the user to be updated.
     * @param userRequest The request body containing the fields to update in the user.
     * @return {@link ResponseEntity} containing the updated user if the update is successful,
     *         or a JSON-formatted error message with a 404 status code if the user is not found.
     *
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable UUID id, @RequestBody UserRequest userRequest) {
        try {
            User user = userService.updateUser(id, userRequest);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("{\"mensaje\": \"" + e.getMessage() + "\"}");
        }
    }
}
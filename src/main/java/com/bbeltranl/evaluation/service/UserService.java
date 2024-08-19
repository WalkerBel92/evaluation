package com.bbeltranl.evaluation.service;

import com.bbeltranl.evaluation.dto.UserRequest;
import com.bbeltranl.evaluation.model.User;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for user-related operations.
 * <p>
 * This interface defines methods to register a new user and retrieve a list of all users.
 * Implementing classes should provide the logic to interact with the data repository and perform
 * CRUD (Create, Read, Update, Delete) operations on user entities.
 * </p>
 *
 * @author bbeltranl
 * @version 1.0
 * @since 2024-06-13
 */
public interface UserService {

    /**
     * Registers a new user based on the information provided in {@code userRequest}.
     *
     * @param user the request object containing user information to be registered.
     * @return the {@link User} entity that has been registered.
     */
    User registerUser(UserRequest user);

    /**
     * Retrieves a list of all users from the data repository.
     *
     * @return a {@link List} of {@link User} entities.
     */
    List<User> listAll();

    /**
     * Retrieves a user based on the provided unique identifier (UUID).
     *
     * @param id The unique identifier of the user to retrieve.
     * @return The {@link User} object corresponding to the provided ID.
     */
    User getUserById(UUID id);

    /**
     * Deletes a user based on the provided unique identifier (UUID).
     *
     * @param id The unique identifier of the user to be deleted.
     */
    void deleteUserById(UUID id);

    /**
     * Updates the user with the specified unique identifier (UUID) using the provided user request data.
     *
     * @param id The unique identifier of the user to be updated.
     * @param userRequest The request object containing the fields to update in the user.
     * @return The updated {@link User} object after the changes have been applied.
     */
    User updateUser(UUID id, UserRequest userRequest);
}

package com.bbeltranl.evaluation.service;

import com.bbeltranl.evaluation.dto.UserRequest;
import com.bbeltranl.evaluation.model.User;

import java.util.List;

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
}

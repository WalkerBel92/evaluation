package com.bbeltranl.evaluation.repository;

import com.bbeltranl.evaluation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for {@link User} entity.
 * <p>
 * This interface extends the {@link JpaRepository} interface from Spring Data JPA, providing
 * CRUD operations and query methods for the {@link User} entity. The primary key type of the
 * entity is {@link UUID}.
 * </p>
 *
 * @author bbeltranl
 * @version 1.0
 * @since 2024-06-13
 */
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Retrieves a {@link User} entity by its email address.
     *
     * @param email the email address of the user to find.
     * @return an {@link Optional} containing the found user, or an empty {@link Optional} if no user was found.
     */
    Optional<User> findByEmail(String email);
}
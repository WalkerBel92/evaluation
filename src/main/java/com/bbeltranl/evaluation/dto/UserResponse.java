package com.bbeltranl.evaluation.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

/**
 * The UserResponse class represents the data transfer object for user-related responses.
 * <p>
 * This class is used to encapsulate the information returned to the client after
 * performing operations such as user retrieval or update. It typically includes
 * fields that are necessary to convey the state of the user entity in response to a request.
 * </p>
 *
 * @author bbeltranl
 * @version 1.0
 * @since 2024-06-13
 */
@Data
public class UserResponse {

    /**
     * The unique identifier of the user.
     */
    private UUID id;

    /**
     * The timestamp when the user was created.
     */
    private Date created;

    /**
     * The timestamp when the user's information was last modified.
     */
    private Date modified;

    /**
     * The timestamp of the user's last login.
     */
    private Date lastLogin;

    /**
     * The authentication token associated with the user.
     */
    private String token;

    /**
     * Indicates whether the user is currently active.
     */
    private boolean isActive;

    /**
     * Sets the user's active status.
     *
     * @param active the active status to set.
     */
    public void setIsActive(boolean active) {
        isActive = active;
    }

    /**
     * Indicates whether the user is currently active.
     *
     * @return true if the user is active, false otherwise.
     */
    public boolean getIsActive() {
        return isActive;
    }
}

package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.User;

/**
 * The interface Users dao.
 */
public interface UsersDAO {

    /**
     * Find by username user.
     *
     * @param username the username
     * @return the user
     */
    User findByUsername(String username);

    /**
     * Register user user.
     *
     * @param userDetails the user details
     * @return the user
     */
    User registerUser(User userDetails);
}

package dev.tobycook.eventize.service;

import dev.tobycook.eventize.dao.UsersDAO;
import dev.tobycook.eventize.model.ApplicationUser;
import dev.tobycook.eventize.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The type App user details service.
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

    /* The logger. */
    private static final Logger LOGGER = LogManager.getLogger(AppUserDetailsService.class);

    /* The users DAO. */
    private UsersDAO usersDAO;

    /**
     * Instantiates a new App user details service.
     *
     * @param usersDAO the users dao
     */
    @Autowired
    public AppUserDetailsService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = usersDAO.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Unable to load user " + username);
        }
        return new ApplicationUser(user);
    }

    /**
     * Register user application user.
     *
     * @param userDetails the user details
     * @return the application user
     */
    public ApplicationUser registerUser(User userDetails) {
        UserDetails user = null;
        try {
            if ((user = loadUserByUsername(userDetails.getUsername())) != null) {
                throw new IllegalArgumentException("Username already exists");
            }
            return new ApplicationUser(userDetails);
        } catch (UsernameNotFoundException e) {
            LOGGER.info("Creating user: {}", user);
            return new ApplicationUser(usersDAO.registerUser(userDetails));
        }
    }
}

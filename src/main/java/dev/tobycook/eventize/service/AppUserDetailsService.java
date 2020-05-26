package dev.tobycook.eventize.service;

import dev.tobycook.eventize.dao.UsersDAO;
import dev.tobycook.eventize.model.ApplicationUser;
import dev.tobycook.eventize.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private UsersDAO usersDAO;

    @Autowired
    public AppUserDetailsService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = usersDAO.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not found: " + username);
        }
        return new ApplicationUser(user);
    }
}

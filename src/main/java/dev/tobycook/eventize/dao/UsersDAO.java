package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.User;

public interface UsersDAO {
    User findByUsername(String username);
}

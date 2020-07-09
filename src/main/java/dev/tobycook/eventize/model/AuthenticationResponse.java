package dev.tobycook.eventize.model;

import java.util.List;

/**
 * The type Authentication response.
 */
public class AuthenticationResponse {

    private final String jwt;
    private String username;
    private List<String> roles;

    /**
     * Instantiates a new Authentication response.
     *
     * @param jwt the jwt
     */
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    /**
     * Gets jwt.
     *
     * @return the jwt
     */
    public String getJwt() {
        return jwt;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public List<String> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

package dev.tobycook.eventize.controller;

import dev.tobycook.eventize.dto.UserDTO;
import dev.tobycook.eventize.model.ApplicationUser;
import dev.tobycook.eventize.model.AuthenticationRequest;
import dev.tobycook.eventize.model.AuthenticationResponse;
import dev.tobycook.eventize.model.User;
import dev.tobycook.eventize.service.AppUserDetailsService;
import dev.tobycook.eventize.util.EntityConverter;
import dev.tobycook.eventize.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Authentication controller.
 */
@RestController
@RequestMapping(value = "/api")
public class AuthenticationController {

    /* The authentication manager. */
    private AuthenticationManager authenticationManager;

    /* The jwt util. */
    private JwtUtil jwtUtil;

    /* The app user details service. */
    private AppUserDetailsService userDetailsService;

    /**
     * Instantiates a new Authentication controller.
     *
     * @param jwtUtil               the jwt util
     * @param userDetailsService    the user details service
     * @param authenticationManager the authentication manager
     */
    @Autowired
    public AuthenticationController(JwtUtil jwtUtil, AppUserDetailsService userDetailsService,
                                    AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Create authentication token response entity.
     *
     * @param authRequest the auth request
     * @return the response entity
     */
    @PostMapping(value = "/login")
    public ResponseEntity<Object> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        final ApplicationUser userDetails = (ApplicationUser) userDetailsService
                .loadUserByUsername(authRequest.getUsername());
        if (!passwordEncoder.matches(authRequest.getPassword(), userDetails.getPassword())) {
            return new ResponseEntity<>("Authentication Failed", HttpStatus.FORBIDDEN);
        }
        final String jwt = jwtUtil.generateToken(userDetails);
        AuthenticationResponse response = new AuthenticationResponse(jwt);
        response.setUsername(userDetails.getUsername());
        List<String> roles = new ArrayList<>();
        userDetails.getAuthorities().forEach(a -> roles.add(a.getAuthority()));
        response.setRoles(roles);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Register user response entity.
     *
     * @param userDetails the user details
     * @return the response entity
     */
    @PostMapping(value = "/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserDTO userDetails) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        EntityConverter entityConverter = new EntityConverter();
        try {
            ApplicationUser appUser = userDetailsService.registerUser(
                    entityConverter.convertToEntity(userDetails, User.class));
            return new ResponseEntity<>(appUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(
                    String.format("Username %s already exists", userDetails.getUsername()), HttpStatus.CONFLICT
            );
        }
    }
}

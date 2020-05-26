package dev.tobycook.eventize.controller;

import dev.tobycook.eventize.model.ApplicationUser;
import dev.tobycook.eventize.model.AuthenticationRequest;
import dev.tobycook.eventize.model.AuthenticationResponse;
import dev.tobycook.eventize.service.AppUserDetailsService;
import dev.tobycook.eventize.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;
    private AppUserDetailsService userDetailsService;

    @Autowired
    public AuthenticationController(JwtUtil jwtUtil, AppUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        final ApplicationUser userDetails = (ApplicationUser) userDetailsService
                .loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        AuthenticationResponse response = new AuthenticationResponse(jwt);
        response.setUsername(userDetails.getUsername());
        List<String> roles = new ArrayList<>();
        userDetails.getAuthorities().forEach(a -> roles.add(a.getAuthority()));
        response.setRoles(roles);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

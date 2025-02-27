package com.zosh.treading.controller;

import java.net.Authenticator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.treading.config.JwtProvider;
import com.zosh.treading.entity.User;
import com.zosh.treading.repository.UserRepository;
import com.zosh.treading.response.AuthResponse;
import com.zosh.treading.service.CustomeUserDetailsService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomeUserDetailsService userDetailsService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody User user) throws Exception {
        
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new Exception("Email already used with another account");
        }
        
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFullName(user.getFullName());

        User savedUser = userRepository.save(newUser);

        org.springframework.security.core.Authentication auth = new UsernamePasswordAuthenticationToken(
                    user.getEmail(),
                    user.getPassword());
                    
        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwt = JwtProvider.generateToken(auth);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setStatus(true);
        authResponse.setMessage("User registered successfully");
        


        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    private UsernamePasswordAuthenticationToken authenticate(String usserName, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(usserName);

        if(userDetails == null){
            throw new BadCredentialsException("User not found");
        }
        if(!password.equals(userDetails.getPassword())){
            throw new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }
}

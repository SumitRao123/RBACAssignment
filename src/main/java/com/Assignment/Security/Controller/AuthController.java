package com.Assignment.Security.Controller;


import com.Assignment.Security.Entity.User;
import com.Assignment.Security.Repository.UserRepository;
import com.Assignment.Security.Service.AuthService;
import com.Assignment.Security.Service.CustomUserDetailsService;
import com.Assignment.Security.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  AuthService authService;

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    private  JwtHelper jwtHelper;


    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        authService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        try{

            String username = request.get("username");
            String password = request.get("password");

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
            String jwt = jwtHelper.generateToken(username);


            return ResponseEntity.ok(jwt);
        }catch (Exception ex){
             return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // For stateless JWT, logout is handled on the client-side by discarding the token.
        return ResponseEntity.ok("Logout successful");
    }
}
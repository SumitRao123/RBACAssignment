package com.Assignment.Security.Service;

import com.Assignment.Security.Entity.User;
import com.Assignment.Security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;



    // Register a new user
    public void registerUser(User user) {
        User nuser = new User();
        nuser.setId(user.getId());
        nuser.setUsername(user.getUsername());
        nuser.setPassword(passwordEncoder.encode(user.getPassword()));
        nuser.setRoles(user.getRoles());
        userRepository.save(user);
    }

    // Fetch user details by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}

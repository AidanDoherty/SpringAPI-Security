package com.example.ScientificFitness.controller;

import com.example.ScientificFitness.db.UserRepository;
import com.example.ScientificFitness.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/public")
public class PublicRestController {
    @Autowired
    public UserRepository userRepository;

    public PublicRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthenticationManager authenticationManager;


    // Available to all authenticated users
    @GetMapping("test")
    public String test1(){
        return "API Test";
    }

    // Available to managers
    @GetMapping("management/reports")
    public String reports(){
        return "Some report data";
    }

    // Available to ROLE_ADMIN
    @GetMapping("admin/users")
    public List<User> users(){
        return this.userRepository.findAll();
    }


}

package com.tutorials.springbook.tutorial.controller;

import com.tutorials.springbook.tutorial.entity.User;
import com.tutorials.springbook.tutorial.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/auth/get-all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> user = userRepository.findAll();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

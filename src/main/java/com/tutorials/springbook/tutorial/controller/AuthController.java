package com.tutorials.springbook.tutorial.controller;

import com.tutorials.springbook.tutorial.dto.LoginRequest;
import com.tutorials.springbook.tutorial.dto.RegisterUserDto;
import com.tutorials.springbook.tutorial.entity.User;
import com.tutorials.springbook.tutorial.response.ApiResponse;
import com.tutorials.springbook.tutorial.response.LoginResponse;
import com.tutorials.springbook.tutorial.service.interfac.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<User>> registerUser(@RequestBody @Valid RegisterUserDto registerUserDto){
        ApiResponse<User> response = userService.register(registerUserDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest){
        LoginResponse response = userService.login(loginRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

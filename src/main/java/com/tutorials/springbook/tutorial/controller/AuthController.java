package com.tutorials.springbook.tutorial.controller;

import com.tutorials.springbook.tutorial.dto.auth.LoginRequest;
import com.tutorials.springbook.tutorial.dto.auth.LoginResponseDto;
import com.tutorials.springbook.tutorial.dto.auth.RegisterRequestDto;
import com.tutorials.springbook.tutorial.dto.auth.RegisterResponseDto;
import com.tutorials.springbook.tutorial.response.ApiResponse;
import com.tutorials.springbook.tutorial.service.interfac.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<RegisterResponseDto>> registerUser(@RequestBody @Valid RegisterRequestDto registerRequestDto){
        ApiResponse<RegisterResponseDto> response = userService.register(registerRequestDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDto>> login(@RequestBody @Valid LoginRequest loginRequest){
        ApiResponse<LoginResponseDto> response = userService.login(loginRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

package com.tutorials.springbook.tutorial.service.interfac;

import com.tutorials.springbook.tutorial.dto.LoginRequest;
import com.tutorials.springbook.tutorial.dto.RegisterUserDto;
import com.tutorials.springbook.tutorial.entity.User;
import com.tutorials.springbook.tutorial.response.ApiResponse;
import com.tutorials.springbook.tutorial.response.LoginResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public interface UserService {

    ApiResponse<User> register(RegisterUserDto user);

    LoginResponse login(LoginRequest req);
}

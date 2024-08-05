package com.tutorials.springbook.tutorial.service.interfac;

import com.tutorials.springbook.tutorial.dto.auth.LoginRequest;
import com.tutorials.springbook.tutorial.dto.auth.LoginResponseDto;
import com.tutorials.springbook.tutorial.dto.auth.RegisterRequestDto;
import com.tutorials.springbook.tutorial.dto.auth.RegisterResponseDto;
import com.tutorials.springbook.tutorial.response.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ApiResponse<RegisterResponseDto> register(RegisterRequestDto user);

    ApiResponse<LoginResponseDto> login(LoginRequest req);
}

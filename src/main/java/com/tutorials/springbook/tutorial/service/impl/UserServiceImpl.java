package com.tutorials.springbook.tutorial.service.impl;

import com.tutorials.springbook.tutorial.constants.ApiResponseConstant;
import com.tutorials.springbook.tutorial.constants.ExceptionConstant;
import com.tutorials.springbook.tutorial.dto.LoginRequest;
import com.tutorials.springbook.tutorial.dto.RegisterUserDto;
import com.tutorials.springbook.tutorial.entity.User;
import com.tutorials.springbook.tutorial.entity.UserRole;
import com.tutorials.springbook.tutorial.exception.IncorrectCredentialsExcpetion;
import com.tutorials.springbook.tutorial.exception.UserAlreadyExistException;
import com.tutorials.springbook.tutorial.mapper.AuthMapper;
import com.tutorials.springbook.tutorial.repo.UserRepository;
import com.tutorials.springbook.tutorial.response.ApiResponse;
import com.tutorials.springbook.tutorial.response.LoginResponse;
import com.tutorials.springbook.tutorial.service.CustomUserDetailsService;
import com.tutorials.springbook.tutorial.service.interfac.UserService;
import com.tutorials.springbook.tutorial.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private AuthMapper authMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public ApiResponse<User> register(RegisterUserDto registerUserDto) {

        Optional<User> existUser = userRepository.findByEmail(registerUserDto.getEmail());
        if(existUser.isPresent()){
            throw new UserAlreadyExistException(ExceptionConstant.USER_ALREADY_EXIST);
        }

        ApiResponse<User> response = new ApiResponse<>();

        registerUserDto.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        User  user = authMapper.RegisterDtoMapToUser(registerUserDto);
        user.setRole(UserRole.USER);
        User savedUser =userRepository.save(user);

        // response created
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setMessage(ApiResponseConstant.USER_CREATED_SUCCESSFULLY);
        response.setData(savedUser);
        return response;
    }

    public LoginResponse login(LoginRequest loginRequest) {

        LoginResponse response = new LoginResponse();
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(),
                    loginRequest.getPassword()));
        }catch (RuntimeException e){
            throw new IncorrectCredentialsExcpetion(ExceptionConstant.INCORRECT_USERNAME_OR_PASSWORD);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        String token = jwtUtils.generateToken(userDetails);

        response.setMessage(ApiResponseConstant.USER_LOGIN_SUCCESSFULLY);
        response.setToken(token);
        response.setStatusCode(HttpStatus.OK.value());
        return response;

    }
}

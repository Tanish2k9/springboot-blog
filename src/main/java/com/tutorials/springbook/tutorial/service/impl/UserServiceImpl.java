package com.tutorials.springbook.tutorial.service.impl;

import com.tutorials.springbook.tutorial.dto.LoginRequest;
import com.tutorials.springbook.tutorial.dto.RegisterUserDto;
import com.tutorials.springbook.tutorial.entity.User;
import com.tutorials.springbook.tutorial.entity.UserRole;
import com.tutorials.springbook.tutorial.mapper.AuthMapper;
import com.tutorials.springbook.tutorial.repo.UserRepository;
import com.tutorials.springbook.tutorial.service.CustomUserDetailsService;
import com.tutorials.springbook.tutorial.service.interfac.UserService;
import com.tutorials.springbook.tutorial.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;

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
    public User register(RegisterUserDto registerUserDto) {
        registerUserDto.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
       User  user = authMapper.RegisterDtoMapToUser(registerUserDto);

       user.setRole(UserRole.USER);
       User savedUser =userRepository.save(user);
       return savedUser;
    }

    public Map<String,String> login(LoginRequest loginRequest) {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(),
                    loginRequest.getPassword()));
        }catch (RuntimeException e){
            throw new RuntimeException("Incorrect username and Password");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        String token = jwtUtils.generateToken(userDetails);
        Map<String,String> map = new HashMap();
        map.put("token",token);
        return map;
    }
}

package com.tutorials.springbook.tutorial.service.interfac;

import com.tutorials.springbook.tutorial.dto.LoginRequest;
import com.tutorials.springbook.tutorial.dto.RegisterUserDto;
import com.tutorials.springbook.tutorial.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public interface UserService {

    User register(RegisterUserDto user);

    Map<String,String> login(LoginRequest req);
}

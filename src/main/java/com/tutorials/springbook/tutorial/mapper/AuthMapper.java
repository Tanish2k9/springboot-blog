package com.tutorials.springbook.tutorial.mapper;

import com.tutorials.springbook.tutorial.dto.auth.RegisterRequestDto;
import com.tutorials.springbook.tutorial.dto.auth.RegisterResponseDto;
import com.tutorials.springbook.tutorial.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {


    public User RegisterDtoMapToUser(RegisterRequestDto dto){

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public RegisterResponseDto UserMapToRegisterResponseDto(User user){
        return RegisterResponseDto.builder()
                .email(user.getEmail())
                .id(user.getId())
                .posts(user.getPosts())
                .role(user.getRole())
                .build();
    }
}

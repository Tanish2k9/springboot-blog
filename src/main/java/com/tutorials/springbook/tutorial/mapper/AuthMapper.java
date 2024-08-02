package com.tutorials.springbook.tutorial.mapper;

import com.tutorials.springbook.tutorial.dto.RegisterUserDto;
import com.tutorials.springbook.tutorial.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {


    public User RegisterDtoMapToUser(RegisterUserDto dto){

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());

        return user;
    }
}

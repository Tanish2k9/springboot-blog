package com.tutorials.springbook.tutorial.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserDto {

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Name is required")
    private String username;

    private String phoneNumber;

    @NotBlank(message = "Password is required")
    private String password;

}

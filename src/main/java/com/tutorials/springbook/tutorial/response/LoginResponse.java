package com.tutorials.springbook.tutorial.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private Integer statusCode;
    private String message;
    private String token;
}

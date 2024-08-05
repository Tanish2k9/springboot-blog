package com.tutorials.springbook.tutorial.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
    private Integer statusCode;
    private String message;
    private T data;
}

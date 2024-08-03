package com.tutorials.springbook.tutorial.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private Integer statusCode;
    private List<String> errors  = new ArrayList<>();
}

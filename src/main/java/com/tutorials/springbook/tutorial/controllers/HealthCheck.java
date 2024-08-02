package com.tutorials.springbook.tutorial.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HealthCheck {

    @GetMapping("/health-check")
    public ResponseEntity<String> healthProgress(){

        return new ResponseEntity<String>("health is 100%", HttpStatus.OK);
    }
}

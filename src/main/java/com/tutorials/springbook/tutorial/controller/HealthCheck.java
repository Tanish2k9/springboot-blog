package com.tutorials.springbook.tutorial.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthCheck {

    @GetMapping("/health-check")
    public ResponseEntity<String> healthProgress(){

        return new ResponseEntity<String>("health is 100%", HttpStatus.OK);
    }

    @PostMapping("/error-checking/{num}")
    public ResponseEntity<String> healthProgress(@PathVariable Integer num){

        int error = 0/num;
        return new ResponseEntity<String>("health is 100%", HttpStatus.OK);
    }
}

package com.tutorials.springbook.tutorial.controller;


import com.tutorials.springbook.tutorial.service.interfac.CloudinaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/upload-image")
public class UploadImageController {
    @Autowired
    private CloudinaryService cloudinaryService;
    @PostMapping
    public ResponseEntity<Map> uploadImage(@RequestParam("image") MultipartFile file){
        return new ResponseEntity<>(cloudinaryService.uploadFile(file), HttpStatus.CREATED);
    }
}

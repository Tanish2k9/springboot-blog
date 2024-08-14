package com.tutorials.springbook.tutorial.service.interfac;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryService {
    Map uploadFile(MultipartFile file);
}

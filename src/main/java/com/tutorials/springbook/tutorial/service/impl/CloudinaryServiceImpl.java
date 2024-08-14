package com.tutorials.springbook.tutorial.service.impl;

import com.cloudinary.Cloudinary;
import com.tutorials.springbook.tutorial.service.interfac.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {

    private final Cloudinary cloudinary;

    @Override
    public Map uploadFile(MultipartFile file) {
        try{
            System.out.println("uploading");
            HashMap<Object, Object> options = new HashMap<>();
            options.put("folder", "sprinboot_tutorial_images");
            Map uploadedFile = cloudinary.uploader().upload(file.getBytes(), options);
            return uploadedFile;
//            String publicId = (String) uploadedFile.get("public_id");
//            return cloudinary.url().secure(true).generate(publicId);

        }catch ( IOException e){
            throw new RuntimeException("Image uploading fail");

        }
    }
}

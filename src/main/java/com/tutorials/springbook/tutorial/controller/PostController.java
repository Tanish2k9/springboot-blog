package com.tutorials.springbook.tutorial.controller;

import com.tutorials.springbook.tutorial.dto.PostRequestDto;
import com.tutorials.springbook.tutorial.dto.PostResponseDto;
import com.tutorials.springbook.tutorial.entity.Post;
import com.tutorials.springbook.tutorial.repo.PostRepository;
import com.tutorials.springbook.tutorial.response.ApiResponse;
import com.tutorials.springbook.tutorial.service.impl.PostServiceImpl;
import com.tutorials.springbook.tutorial.service.interfac.PostService;
import com.tutorials.springbook.tutorial.util.JWTUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;



    @Autowired
    private JWTUtils jwtUtils;

    @PostMapping
    public ApiResponse<PostResponseDto> createPost(@RequestBody  @Valid  PostRequestDto postRequestDto){

        ApiResponse<PostResponseDto> response = postService.createPost(postRequestDto);
        return response;
    }
}

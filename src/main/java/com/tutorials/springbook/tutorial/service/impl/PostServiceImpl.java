package com.tutorials.springbook.tutorial.service.impl;

import com.tutorials.springbook.tutorial.constants.ApiResponseConstant;
import com.tutorials.springbook.tutorial.dto.post.PostRequestDto;
import com.tutorials.springbook.tutorial.dto.post.PostResponseDto;
import com.tutorials.springbook.tutorial.entity.Post;
import com.tutorials.springbook.tutorial.entity.User;
import com.tutorials.springbook.tutorial.mapper.PostMapper;
import com.tutorials.springbook.tutorial.repo.PostRepository;
import com.tutorials.springbook.tutorial.response.ApiResponse;
import com.tutorials.springbook.tutorial.service.interfac.PostService;
import com.tutorials.springbook.tutorial.util.JWTUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private JWTUtils jwtUtils;


    @Override
    @Transactional
    public ApiResponse<PostResponseDto> createPost(PostRequestDto postRequestDto) {

        ApiResponse response = new ApiResponse<>();
        Post post = postMapper.convertPostRequestDtoToPost(postRequestDto);
        User userData = jwtUtils.getLoggedInUser();

        post.setUser(userData);


        Post savedPost = postRepository.save(post);
        PostResponseDto postResponseDto =postMapper.convertPostToPostResponseDto(savedPost);



        response.setMessage(ApiResponseConstant.POST_CREATED_SUCCESSFULLY);
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setData(postResponseDto);

        return response;
    }

    @Override
    @Transactional
    public ApiResponse<List<PostResponseDto>> getAllPosts() {

        List<PostResponseDto> posts = postRepository.findAll().stream().map((post)->{
            return postMapper.convertPostToPostResponseDto(post);
        }).collect(Collectors.toList());


        return ApiResponse.<List<PostResponseDto>>builder()
                .data(posts)
                .message("posts fetched sucessfully")
                .statusCode(HttpStatus.OK.value())
                .build();
    }


}

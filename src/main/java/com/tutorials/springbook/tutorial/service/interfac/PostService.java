package com.tutorials.springbook.tutorial.service.interfac;

import com.tutorials.springbook.tutorial.dto.PostRequestDto;
import com.tutorials.springbook.tutorial.dto.PostResponseDto;
import com.tutorials.springbook.tutorial.response.ApiResponse;

public interface PostService {

    ApiResponse<PostResponseDto> createPost(PostRequestDto postRequestDto);
}

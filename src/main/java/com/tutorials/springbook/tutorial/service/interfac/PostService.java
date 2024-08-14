package com.tutorials.springbook.tutorial.service.interfac;

import com.tutorials.springbook.tutorial.dto.post.PostRequestDto;
import com.tutorials.springbook.tutorial.dto.post.PostResponseDto;
import com.tutorials.springbook.tutorial.response.ApiResponse;
import com.tutorials.springbook.tutorial.response.PaginationResponse;

import java.util.List;

public interface PostService {

    ApiResponse<PostResponseDto> createPost(PostRequestDto postRequestDto);
    ApiResponse<List<PostResponseDto>> getAllPosts();

    PaginationResponse<List<PostResponseDto>> getAllPostsWithPagination(Integer pageNumber, Integer pageSize);

    PaginationResponse<List<PostResponseDto>> getAllPostsWithPaginationAndSort(Integer pageNumber,Integer pageSize,String sortBy,String dir);
}

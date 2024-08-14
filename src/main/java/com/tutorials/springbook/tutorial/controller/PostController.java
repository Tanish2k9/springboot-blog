package com.tutorials.springbook.tutorial.controller;

import com.tutorials.springbook.tutorial.constants.ApiConstant;
import com.tutorials.springbook.tutorial.dto.post.PostRequestDto;
import com.tutorials.springbook.tutorial.dto.post.PostResponseDto;
import com.tutorials.springbook.tutorial.response.ApiResponse;
import com.tutorials.springbook.tutorial.response.PaginationResponse;
import com.tutorials.springbook.tutorial.service.interfac.PostService;
import com.tutorials.springbook.tutorial.util.JWTUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public ApiResponse<List<PostResponseDto>> getAllPosts(){
        ApiResponse<List<PostResponseDto>> response = postService.getAllPosts();
        return response;
    }


    @GetMapping("/with-paginate")
    public PaginationResponse<List<PostResponseDto>> getAllPostsWithPagination(
            @RequestParam(defaultValue = ApiConstant.PAGE_NUMBER,required = false) Integer pageNumber,
            @RequestParam(defaultValue = ApiConstant.PAGE_SIZE,required = false) Integer pageSize

    ){
        PaginationResponse<List<PostResponseDto>> response = postService.getAllPostsWithPagination(pageNumber,pageSize);
        return response;
    }
    @GetMapping("/with-paginate-and-sort")
    public PaginationResponse<List<PostResponseDto>> getAllPostsWithPaginationAndSorting(

            @RequestParam(defaultValue = ApiConstant.PAGE_NUMBER,required = false) Integer pageNumber,
            @RequestParam(defaultValue = ApiConstant.PAGE_SIZE,required = false) Integer pageSize,
            @RequestParam(defaultValue = ApiConstant.SORT_BY,required = false) String sortBy,
            @RequestParam(defaultValue = ApiConstant.SORT_DIR,required = false) String sortDir
    ){
        PaginationResponse<List<PostResponseDto>> response= postService.getAllPostsWithPaginationAndSort(pageNumber,pageSize,sortBy,sortDir);
        return response;
    }


}

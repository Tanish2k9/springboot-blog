package com.tutorials.springbook.tutorial.service.impl;

import com.tutorials.springbook.tutorial.constants.ApiResponseConstant;
import com.tutorials.springbook.tutorial.dto.post.PostRequestDto;
import com.tutorials.springbook.tutorial.dto.post.PostResponseDto;
import com.tutorials.springbook.tutorial.entity.Post;
import com.tutorials.springbook.tutorial.entity.User;
import com.tutorials.springbook.tutorial.mapper.PostMapper;
import com.tutorials.springbook.tutorial.repo.PostRepository;
import com.tutorials.springbook.tutorial.response.ApiResponse;
import com.tutorials.springbook.tutorial.response.PaginationResponse;
import com.tutorials.springbook.tutorial.service.interfac.PostService;
import com.tutorials.springbook.tutorial.util.JWTUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public PaginationResponse<List<PostResponseDto>> getAllPostsWithPagination(Integer pageNumber,Integer pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Post> postPage= postRepository.findAll(pageable);
        List<Post> allPosts = postPage.getContent();
        List<PostResponseDto> postsResponse = allPosts.stream().map((post)->{
            return postMapper.convertPostToPostResponseDto(post);
        }).collect(Collectors.toList());

        return PaginationResponse.<List<PostResponseDto>>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Posts fetched successfully")
                .pageNumber(postPage.getNumber())
                .pageSize(postPage.getSize())
                .totalElements(postPage.getTotalElements())
                .totalPages(postPage.getTotalPages())
                .isLast(postPage.isLast())
                .data(postsResponse)
                .build();
    }

    public PaginationResponse<List<PostResponseDto>> getAllPostsWithPaginationAndSort(Integer pageNumber,Integer pageSize,String sortBy,String dir){
        Sort sort = dir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<Post> postPage= postRepository.findAll(pageable);
        List<Post> allPosts = postPage.getContent();
        List<PostResponseDto> postsResponse = allPosts.stream().map((post)->{
            return postMapper.convertPostToPostResponseDto(post);
        }).collect(Collectors.toList());

        return PaginationResponse.<List<PostResponseDto>>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Posts fetched successfully")
                .pageNumber(postPage.getNumber())
                .pageSize(postPage.getSize())
                .totalElements(postPage.getTotalElements())
                .totalPages(postPage.getTotalPages())
                .isLast(postPage.isLast())
                .data(postsResponse)
                .build();
    }


}

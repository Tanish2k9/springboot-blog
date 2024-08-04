package com.tutorials.springbook.tutorial.mapper;

import com.tutorials.springbook.tutorial.dto.PostRequestDto;
import com.tutorials.springbook.tutorial.dto.PostResponseDto;
import com.tutorials.springbook.tutorial.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post convertPostRequestDtoToPost(PostRequestDto postRequestDto){
        Post post = new Post();
        post.setDescription(postRequestDto.getDescription());
        post.setTitle(postRequestDto.getTitle());
        post.setImageUrl(postRequestDto.getImageUrl());
        return post;
    }

    public PostResponseDto convertPostToPostResponseDto(Post post){
        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setDescription(post.getDescription());
        postResponseDto.setTitle(post.getTitle());
        postResponseDto.setImageUrl(post.getImageUrl());
        postResponseDto.setId(post.getId());
        return postResponseDto;
    }
}

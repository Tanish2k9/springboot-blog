package com.tutorials.springbook.tutorial.controller;

import com.tutorials.springbook.tutorial.dto.comment.CommentRequestDto;
import com.tutorials.springbook.tutorial.entity.Comment;
import com.tutorials.springbook.tutorial.response.ApiResponse;
import com.tutorials.springbook.tutorial.service.interfac.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/post/{postId}/comment")
    public ResponseEntity<ApiResponse<List<Comment>>> getPostComments(@PathVariable Integer postId){
        var response =commentService.getPostComments(postId);
        return new ResponseEntity<ApiResponse<List<Comment>>>(response, HttpStatus.OK);
    }

    @PostMapping("/post/{postId}/comment")
    public ResponseEntity<ApiResponse<Comment>> createPostComment(@PathVariable Integer postId, @RequestBody CommentRequestDto commentRequestDto){
        var response =commentService.createComment(postId,commentRequestDto);
        return new ResponseEntity<ApiResponse<Comment>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/post/comment/{commentId}")
    public ResponseEntity<ApiResponse<Comment>> updatePostComment(@PathVariable Integer commentId, @RequestBody CommentRequestDto commentRequestDto){
        var response =commentService.updateCommet(commentId,commentRequestDto);
        return new ResponseEntity<ApiResponse<Comment>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/post/comment/{commentId}")
    public ResponseEntity<ApiResponse<String>> deletePostComment(@PathVariable Integer commentId){
        var response =commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse<String>>(response, HttpStatus.OK);
    }
}

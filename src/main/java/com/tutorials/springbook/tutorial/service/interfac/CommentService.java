package com.tutorials.springbook.tutorial.service.interfac;

import com.tutorials.springbook.tutorial.dto.comment.CommentRequestDto;
import com.tutorials.springbook.tutorial.entity.Comment;
import com.tutorials.springbook.tutorial.response.ApiResponse;

import java.util.List;

public interface CommentService {
    ApiResponse<Comment> createComment(Integer postId, CommentRequestDto commentRequestDto);

    ApiResponse<List<Comment>> getPostComments(Integer postId);


    ApiResponse<String> deleteComment(Integer CommentId);

    ApiResponse<Comment> updateCommet(Integer commentId, CommentRequestDto commentRequestDto);
}

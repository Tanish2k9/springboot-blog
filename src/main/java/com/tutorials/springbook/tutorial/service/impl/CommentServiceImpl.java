package com.tutorials.springbook.tutorial.service.impl;

import com.tutorials.springbook.tutorial.dto.comment.CommentRequestDto;
import com.tutorials.springbook.tutorial.entity.Comment;
import com.tutorials.springbook.tutorial.entity.Post;
import com.tutorials.springbook.tutorial.entity.User;
import com.tutorials.springbook.tutorial.mapper.CommentMapper;
import com.tutorials.springbook.tutorial.repo.CommentRepository;
import com.tutorials.springbook.tutorial.repo.PostRepository;
import com.tutorials.springbook.tutorial.response.ApiResponse;
import com.tutorials.springbook.tutorial.service.interfac.CommentService;

import com.tutorials.springbook.tutorial.util.JWTUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final JWTUtils jwtUtils;

    @Override
    @Transactional
    public ApiResponse<Comment> createComment(Integer postId, CommentRequestDto commentRequestDto) {

        User user = jwtUtils.getLoggedInUser();
        Optional<Post> post = postRepository.findById(postId);
        if(!post.isPresent()){
           throw new RuntimeException("Post not found");
        }
        Comment comment = commentMapper.CommentRequestDtoToComment(commentRequestDto);
        comment.setPost(post.get());
        comment.setUser(user);
        Comment savedComment = commentRepository.save(comment);
//
//        post.get().getComments().add(savedComment);
//        user.getComments().add(savedComment);
        return ApiResponse.<Comment>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Comment created successfully")
                .data(comment)
                .build();
    }

    @Override
    public ApiResponse<List<Comment>> getPostComments(Integer postId) {
        Optional<Post> post = postRepository.findById(postId);

        if(!post.isPresent()){
            throw new RuntimeException("Post not found");
        }
        var comments = post.get().getComments();
        return ApiResponse.<List<Comment>>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Comment fetched successfully")
                .data(comments)
                .build();
    }
    @Transactional
    @Override
    public ApiResponse<String> deleteComment(Integer commentId) {
        var oldComment = commentRepository.findById(commentId);
        User user = jwtUtils.getLoggedInUser();
        if(oldComment.isEmpty()){
            throw new RuntimeException("Comment not found");
        }
        if(oldComment.get().getUser().getId() != user.getId()){
            throw new RuntimeException("you cant delete others user comment");
        }

        commentRepository.deleteCommentById(commentId);

        return ApiResponse.<String>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Delete comment successfully")
                .data(null)
                .build();
    }

    @Override
    public ApiResponse<Comment> updateCommet(Integer commentId, CommentRequestDto commentRequestDto) {
        var oldComment = commentRepository.findById(commentId);
        User user = jwtUtils.getLoggedInUser();
        if(oldComment.isEmpty()){
            throw new RuntimeException("Comment not found");
        }
        if(oldComment.get().getUser().getId() != user.getId()){
            throw new RuntimeException("you cant update others user comment");
        }
        oldComment.get().setContent(commentRequestDto.getContent());
        commentRepository.save(oldComment.get());
        return ApiResponse.<Comment>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Comment updated  successfully")
                .data(oldComment.get())
                .build();
    }
}

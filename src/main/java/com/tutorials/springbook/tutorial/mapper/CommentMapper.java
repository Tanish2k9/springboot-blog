package com.tutorials.springbook.tutorial.mapper;

import com.tutorials.springbook.tutorial.dto.comment.CommentRequestDto;
import com.tutorials.springbook.tutorial.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public Comment CommentRequestDtoToComment(CommentRequestDto commentRequestDto){
        return Comment.builder()
                .content(commentRequestDto.getContent())
                .build();
    }
}

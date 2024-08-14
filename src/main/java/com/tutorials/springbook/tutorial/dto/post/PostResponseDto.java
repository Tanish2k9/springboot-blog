package com.tutorials.springbook.tutorial.dto.post;


import com.tutorials.springbook.tutorial.entity.Comment;
import com.tutorials.springbook.tutorial.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponseDto {

    private Integer id;
    private String title;

    private String description;

    private String imageUrl;

    private UserDtoFroPost user;
}

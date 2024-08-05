package com.tutorials.springbook.tutorial.dto.post;


import com.tutorials.springbook.tutorial.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

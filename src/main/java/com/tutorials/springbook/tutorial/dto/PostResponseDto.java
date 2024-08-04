package com.tutorials.springbook.tutorial.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {

    private Integer id;
    private String title;

    private String description;

    private String imageUrl;
}

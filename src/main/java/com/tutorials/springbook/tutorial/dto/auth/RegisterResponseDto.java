package com.tutorials.springbook.tutorial.dto.auth;

import com.tutorials.springbook.tutorial.entity.Post;
import com.tutorials.springbook.tutorial.entity.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterResponseDto {
    private Long id;
    private String email;
    private UserRole role;
    private List<Post> posts;
}

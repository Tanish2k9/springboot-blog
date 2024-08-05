package com.tutorials.springbook.tutorial.dto.post;

import com.tutorials.springbook.tutorial.entity.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDtoFroPost {

    private Long id;

    private String email;

    private UserRole role;
}

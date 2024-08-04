package com.tutorials.springbook.tutorial.repo;

import com.tutorials.springbook.tutorial.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}

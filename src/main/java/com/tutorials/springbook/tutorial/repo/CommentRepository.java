package com.tutorials.springbook.tutorial.repo;

import com.tutorials.springbook.tutorial.entity.Comment;
import com.tutorials.springbook.tutorial.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findByPost(Post post);

    @Modifying
    @Query("DELETE FROM Comment c WHERE c.id = :commentId")
    void deleteCommentById(@Param("commentId") Integer commentId);
//    Void deleteComment(@query commentId);
}

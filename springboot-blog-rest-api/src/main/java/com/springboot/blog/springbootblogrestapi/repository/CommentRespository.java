package com.springboot.blog.springbootblogrestapi.repository;

import com.springboot.blog.springbootblogrestapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface CommentRespository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}

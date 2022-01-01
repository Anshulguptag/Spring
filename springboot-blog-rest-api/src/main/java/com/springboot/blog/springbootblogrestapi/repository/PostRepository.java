package com.springboot.blog.springbootblogrestapi.repository;

import com.springboot.blog.springbootblogrestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Post repository.
 */
public interface PostRepository extends JpaRepository<Post, Long> {

}

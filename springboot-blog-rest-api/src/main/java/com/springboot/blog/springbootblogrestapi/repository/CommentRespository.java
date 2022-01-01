package com.springboot.blog.springbootblogrestapi.repository;

import com.springboot.blog.springbootblogrestapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

/**
 * The interface Comment respository.
 */
public interface CommentRespository extends JpaRepository<Comment, Long> {
    /**
     * Find by post id list.
     *
     * @param postId the post id
     * @return the list
     */
    List<Comment> findByPostId(long postId);
}

package com.springboot.blog.springbootblogrestapi.service;

import com.springboot.blog.springbootblogrestapi.payload.PostDto;
import com.springboot.blog.springbootblogrestapi.payload.PostResponse;

/**
 * The interface Post service.
 */
public interface PostService {
    /**
     * Create post post dto.
     *
     * @param postDto the post dto
     * @return the post dto
     */
    PostDto createPost(PostDto postDto);

    /**
     * Gets all posts.
     *
     * @param pageNo   the page no
     * @param pageSize the page size
     * @param sortBy   the sort by
     * @param sortDir  the sort dir
     * @return the all posts
     */
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    /**
     * Gets post by id.
     *
     * @param id the id
     * @return the post by id
     */
    PostDto getPostById(long id);

    /**
     * Update post post dto.
     *
     * @param postDto the post dto
     * @param id      the id
     * @return the post dto
     */
    PostDto updatePost(PostDto postDto, long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(long id);
}

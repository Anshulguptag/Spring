package com.springboot.blog.springbootblogrestapi.controller;

import com.springboot.blog.springbootblogrestapi.payload.PostDto;
import com.springboot.blog.springbootblogrestapi.payload.PostResponse;
import com.springboot.blog.springbootblogrestapi.service.PostService;
import com.springboot.blog.springbootblogrestapi.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Post controller.
 */
/*
RestController is a Spring annotation that is used to build REST API in a declarative way.
RestController annotation is applied to a class to mark it as a request handler, and
Spring will do the building and provide the RESTful web service at runtime.

@RestController is the combination of @Controller and @ResponseBody .
 */
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    /**
     * Instantiates a new Post controller.
     *
     * @param postService the post service
     */
    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Create post response entity.
     *
     * @param postDto the post dto
     * @return the response entity
     */
    //create blog post
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    /*
    ResponseEntity is an extension of HttpEntity that represents an
    HTTP response including status, headers and body. ResponseEntity allows you
    to modify the response with optional headers and status code.
    In spring applications, ResponseEntity is used in @Controller methods as well as in RestTemplate.
     */
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    /**
     * Gets all posts.
     *
     * @param pageNo   the page no
     * @param pageSize the page size
     * @param sortBy   the sort by
     * @param sortDir  the sort dir
     * @return the all posts
     */
   // get all blog posts
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ) {
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    /**
     * Gets post by id.
     *
     * @param id the id
     * @return the post by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    /**
     * Update post response entity.
     *
     * @param postDto the post dto
     * @param id      the id
     * @return the response entity
     */
    // update post by id
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        PostDto postResponse = postService.updatePost(postDto, id);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    /**
     * Delete post response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deleteById(id);
        return new ResponseEntity<>("Post deleted successfully...", HttpStatus.OK);
    }
}

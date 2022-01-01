package com.springboot.blog.springbootblogrestapi.payload;

import lombok.Data;

/**
 * The type Post dto.
 */
@Data
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;
}

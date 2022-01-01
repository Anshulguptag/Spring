package com.springboot.blog.springbootblogrestapi.service;

import com.springboot.blog.springbootblogrestapi.payload.CommentDto;

import java.util.List;

/**
 * The interface Comment service.
 */
public interface CommentService {
    /**
     * Create comment comment dto.
     *
     * @param postId     the post id
     * @param commentDto the comment dto
     * @return the comment dto
     */
    CommentDto createComment(long postId, CommentDto commentDto);

    /**
     * Gets comments by post id.
     *
     * @param postId the post id
     * @return the comments by post id
     */
    List<CommentDto> getCommentsByPostId(long postId);

    /**
     * Gets comment by id.
     *
     * @param postId    the post id
     * @param commentId the comment id
     * @return the comment by id
     */
    CommentDto getCommentById(long postId, long commentId);

    /**
     * Update comment by id comment dto.
     *
     * @param postId     the post id
     * @param commentId  the comment id
     * @param commentDto the comment dto
     * @return the comment dto
     */
    CommentDto updateCommentById(long postId, long commentId, CommentDto commentDto);
}

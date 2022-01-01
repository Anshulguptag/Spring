package com.springboot.blog.springbootblogrestapi.controller;

import com.springboot.blog.springbootblogrestapi.payload.CommentDto;
import com.springboot.blog.springbootblogrestapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Comment controller.
 */
@RestController
@RequestMapping("/api/")
public class CommentController {
    private final CommentService commentService;

    /**
     * Instantiates a new Comment controller.
     *
     * @param commentService the comment service
     */
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    /**
     * Gets all comments.
     *
     * @param postId the post id
     * @return the all comments
     */
    @GetMapping("/post/{postId}/comments")
    public List<CommentDto> getAllComments(@PathVariable(name = "postId") long postId){
        return commentService.getCommentsByPostId(postId);
    }

    /**
     * Create comment response entity.
     *
     * @param postId     the post id
     * @param commentDto the comment dto
     * @return the response entity
     */
    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(name = "postId") long postId,
                                                    @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    /**
     * Gets comment by id.
     *
     * @param postId    the post id
     * @param commentId the comment id
     * @return the comment by id
     */
    @GetMapping("/post/{postId}/comment/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(name = "postId") long postId,
                                                     @PathVariable(name = "commentId") long commentId){
        return new ResponseEntity<>(commentService.getCommentById(postId, commentId), HttpStatus.OK);
    }

    /**
     * Update comment response entity.
     *
     * @param postId     the post id
     * @param commentId  the comment id
     * @param commentDto the comment dto
     * @return the response entity
     */
    @PutMapping("/post/{postId}/comment/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(name = "postId") long postId,
                                                     @PathVariable(name = "commentId") long commentId,
                                                     @RequestBody CommentDto commentDto){
        CommentDto updateComment = commentService.updateCommentById(postId, commentId, commentDto);
        return new ResponseEntity<>(updateComment, HttpStatus.OK);
    }

    /**
     * Delete comment response entity.
     *
     * @param postId    the post id
     * @param commentId the comment id
     * @return the response entity
     */
    @DeleteMapping("/post/{postId}/comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable(name = "postId") long postId,
                                                    @PathVariable(name = "commentId") long commentId){
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment is deleted successfully", HttpStatus.OK);
    }
}

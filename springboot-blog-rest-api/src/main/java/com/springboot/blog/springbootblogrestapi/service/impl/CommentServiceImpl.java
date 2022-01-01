package com.springboot.blog.springbootblogrestapi.service.impl;

import com.springboot.blog.springbootblogrestapi.entity.Comment;
import com.springboot.blog.springbootblogrestapi.entity.Post;
import com.springboot.blog.springbootblogrestapi.exception.BlogApiException;
import com.springboot.blog.springbootblogrestapi.exception.ResourceNotFound;
import com.springboot.blog.springbootblogrestapi.payload.CommentDto;
import com.springboot.blog.springbootblogrestapi.repository.CommentRespository;
import com.springboot.blog.springbootblogrestapi.repository.PostRepository;
import com.springboot.blog.springbootblogrestapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Comment service.
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRespository commentRespository;
    private final PostRepository postRepository;

    /**
     * Instantiates a new Comment service.
     *
     * @param commentRespository the comment respository
     * @param postRepository     the post repository
     */
    public CommentServiceImpl(CommentRespository commentRespository, PostRepository postRepository) {
        this.commentRespository = commentRespository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {

        Comment comment = mapToEntity(commentDto);

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFound("Post", "id", postId));

        comment.setPost(post);

        Comment newComment = commentRespository.save(comment);

        return mapToDTO(newComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        //retrieve comments by postId
        List<Comment> comments = commentRespository.findByPostId(postId);

        return comments.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(long postId, long commentId) {
        Comment comment = checkStatus(postId, commentId);
        return mapToDTO(comment);
    }

    @Override
    public CommentDto updateCommentById(long postId, long commentId, CommentDto commentDto) {

        Comment comment = checkStatus(postId, commentId);

        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        Comment updatedComment = commentRespository.save(comment);

        return mapToDTO(updatedComment);
    }

    @Override
    public void deleteComment(long postId, long commentId) {
        Comment comment = checkStatus(postId, commentId);
        commentRespository.delete(comment);
    }

    private CommentDto mapToDTO(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setBody(comment.getBody());
        commentDto.setEmail(comment.getEmail());
        commentDto.setName(comment.getName());

        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        comment.setName(commentDto.getName());

        return comment;
    }

    private Comment checkStatus(long postId, long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFound("Post", "id", postId)
        );
        Comment comment = commentRespository.findById(commentId).orElseThrow(
                () -> new ResourceNotFound("Comment", "id", commentId)
        );
        if (!Long.valueOf(comment.getPost().getId()).equals(post.getId()))
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment not belong to this post");
        return comment;
    }
}

package com.springboot.blog.springbootblogrestapi.exception;

import com.springboot.blog.springbootblogrestapi.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * The type Global exception handler.
 */
@ControllerAdvice
/*
@ControllerAdvice is a specialization of the @Component
annotation which allows to handle exceptions across the whole application
in one global handling component.
It can be viewed as an interceptor of exceptions thrown by methods
annotated with @RequestMapping and similar.
 */
public class GlobalExceptionHandler {

    /**
     * Handle resource not found exception response entity.
     *
     * @param resourceNotFound the resource not found
     * @param webRequest       the web request
     * @return the response entity
     */
//handle specific exceptions
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFound resourceNotFound,
                                                                        WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), resourceNotFound.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle blog api exception response entity.
     *
     * @param blogApiException the blog api exception
     * @param webRequest       the web request
     * @return the response entity
     */
    @ExceptionHandler(BlogApiException.class)
    public ResponseEntity<ErrorDetails> handleBlogApiException(BlogApiException blogApiException,
                                                               WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), blogApiException.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle global response entity.
     *
     * @param exception  the exception
     * @param webRequest the web request
     * @return the response entity
     */
// global exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobal(Exception exception,
                                                     WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

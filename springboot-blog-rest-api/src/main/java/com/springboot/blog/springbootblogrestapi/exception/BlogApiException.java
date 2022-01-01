package com.springboot.blog.springbootblogrestapi.exception;

import org.springframework.http.HttpStatus;

/**
 * The type Blog api exception.
 */
public class BlogApiException extends RuntimeException{

    private HttpStatus httpStatus;
    private String message;

    /**
     * Instantiates a new Blog api exception.
     *
     * @param httpStatus the http status
     * @param message    the message
     */
    public BlogApiException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    /**
     * Instantiates a new Blog api exception.
     *
     * @param message    the message
     * @param httpStatus the http status
     * @param message1   the message 1
     */
    public BlogApiException(String message, HttpStatus httpStatus, String message1) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message1;
    }

    /**
     * Gets http status.
     *
     * @return the http status
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * Sets http status.
     *
     * @param httpStatus the http status
     */
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}

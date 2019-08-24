package com.userpanel.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}


package com.example.quadratic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InfinityOrNaNException extends RuntimeException {

    public InfinityOrNaNException() {
        super("Infinity Or NaN result.");
    }
}


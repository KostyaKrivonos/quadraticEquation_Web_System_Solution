package com.example.quadratic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundEquationException extends RuntimeException {

    public NotFoundEquationException() {
        super("Not found equation.");
    }
}


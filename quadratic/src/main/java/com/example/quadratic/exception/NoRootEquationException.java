package com.example.quadratic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoRootEquationException extends RuntimeException {

    public NoRootEquationException() {
        super("Discriminant less than 0.");
    }
}


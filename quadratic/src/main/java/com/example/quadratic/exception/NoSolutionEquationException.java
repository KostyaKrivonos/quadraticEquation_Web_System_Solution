package com.example.quadratic.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSolutionEquationException extends RuntimeException {

    public NoSolutionEquationException() {

        super("Equation has no solution.");
        log.info("[x] Equation has no solution.");
    }
}


package com.example.quadratic.quadratic.handler.api;

import com.example.quadratic.quadratic.model.dto.QuadraticEquationDto;
import com.example.quadratic.quadratic.request.QuadraticEquationRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuadraticEquationHandler {
    ResponseEntity<QuadraticEquationDto> calculate(QuadraticEquationRequest request);

    ResponseEntity<List<QuadraticEquationDto>> getAll();
}

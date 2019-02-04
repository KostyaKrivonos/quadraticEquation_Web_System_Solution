package com.example.quadratic.quadratic.controller;


import com.example.quadratic.quadratic.handler.api.QuadraticEquationHandler;
import com.example.quadratic.quadratic.model.dto.QuadraticEquationDto;
import com.example.quadratic.quadratic.request.QuadraticEquationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equations")
@RequiredArgsConstructor
public class QuadraticEquationController {
    private QuadraticEquationHandler quadraticEquationHandler;

    @PostMapping("/calculation")
    public ResponseEntity<QuadraticEquationDto> searchAircraft(@Valid @RequestBody QuadraticEquationRequest request) {
        return quadraticEquationHandler.calculate(request);
    }

    @GetMapping
    public ResponseEntity<List<QuadraticEquationDto>> getAllEquation() {
        return quadraticEquationHandler.getAll();
    }

}

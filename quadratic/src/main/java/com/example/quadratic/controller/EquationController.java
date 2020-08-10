package com.example.quadratic.controller;


import com.example.quadratic.protocol.dto.QuadraticEquationDto;
import com.example.quadratic.request.QuadraticEquationRequest;
import com.example.quadratic.service.impl.QuadraticEquationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/equation")
public class EquationController {

    private QuadraticEquationServiceImpl quadraticEquationServiceImpl;

    @Value("${message.error}")
    private String errorMessage;

    @Autowired
    public EquationController(QuadraticEquationServiceImpl quadraticEquationServiceImpl) {
        this.quadraticEquationServiceImpl = quadraticEquationServiceImpl;
    }

    @PostMapping("/calculation")
    public ResponseEntity<QuadraticEquationDto> calculation(@Valid @RequestBody QuadraticEquationRequest equationRequest) {
        return ResponseEntity.ok(quadraticEquationServiceImpl.calculate(equationRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuadraticEquationDto>> getAllEquation() {
        return ResponseEntity.ok(quadraticEquationServiceImpl.getAll());

    }
}

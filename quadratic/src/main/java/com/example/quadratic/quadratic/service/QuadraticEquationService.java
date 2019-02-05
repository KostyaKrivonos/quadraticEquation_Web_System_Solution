package com.example.quadratic.quadratic.service;

import com.example.quadratic.quadratic.model.QuadraticEquation;
import com.example.quadratic.quadratic.repository.QuadraticEquationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Kostya Krivonos
 * 2/4/19
 * 5:46 PM
 */

@Slf4j
@Component
public class QuadraticEquationService {
    private QuadraticEquationRepository quadraticEquationRepository;

    @Autowired
    public QuadraticEquationService(QuadraticEquationRepository quadraticEquationRepository) {
        this.quadraticEquationRepository = quadraticEquationRepository;
    }

    
    public QuadraticEquation save(QuadraticEquation equation) {
        log.info("[x] QuadraticEquation: [{}], saved.", equation);
        return quadraticEquationRepository.save(equation);
    }

    
    public List<QuadraticEquation> findAll() {
        log.info("[x] Got all Quadratic Equation.");
        return quadraticEquationRepository.findAll();
    }

    public QuadraticEquation check(double a, double b, double c) {
        return quadraticEquationRepository.findByABC(a, b, c);
    }
}

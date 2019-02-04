package com.example.quadratic.quadratic.service.impl;

import com.example.quadratic.quadratic.model.QuadraticEquation;
import com.example.quadratic.quadratic.repository.QuadraticEquationRepository;
import com.example.quadratic.quadratic.service.api.QuadraticEquationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Kostya Krivonos
 * 2/4/19
 * 5:46 PM
 */

@Slf4j
@Service
public class QuadraticEquationServiceImpl implements QuadraticEquationService {
    private QuadraticEquationRepository quadraticEquationRepository;

    public QuadraticEquationServiceImpl(QuadraticEquationRepository quadraticEquationRepository) {
        this.quadraticEquationRepository = quadraticEquationRepository;
    }

    @Override
    public QuadraticEquation save(QuadraticEquation equation) {
        log.info("[x] QuadraticEquation: [{}], saved.", equation);
        return quadraticEquationRepository.save(equation);
    }

    @Override
    public List<QuadraticEquation> findAll() {
        log.info("[x] Got all Quadratic Equation.");
        return quadraticEquationRepository.findAll();
    }


}

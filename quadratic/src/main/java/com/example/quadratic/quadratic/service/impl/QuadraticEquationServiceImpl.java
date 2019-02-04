package com.example.quadratic.quadratic.service.impl;

import com.example.quadratic.quadratic.model.QuadraticEquation;
import com.example.quadratic.quadratic.repository.QuadraticEquationRepository;
import com.example.quadratic.quadratic.service.api.QuadraticEquationService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class QuadraticEquationServiceImpl implements QuadraticEquationService {
    private QuadraticEquationRepository quadraticEquationRepository;

    @Override
    public QuadraticEquation save(QuadraticEquation equation) {
        return quadraticEquationRepository.save(equation);
    }

    @Override
    public List<QuadraticEquation> findAll() {
        return null;
    }
}

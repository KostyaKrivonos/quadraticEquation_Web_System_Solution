package com.example.quadratic.quadratic.service.api;

import com.example.quadratic.quadratic.model.QuadraticEquation;

import java.util.List;

/**
 * Kostya Krivonos
 * 2/4/19
 * 5:40 PM
 */

public interface QuadraticEquationService {
    QuadraticEquation save(QuadraticEquation equation);

    List<QuadraticEquation> findAll();

}

package com.example.quadratic.quadratic.repository;

import com.example.quadratic.quadratic.model.QuadraticEquation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Kostya Krivonos
 * 2/4/19
 * 3:47 PM
 */

@Repository
public interface QuadraticEquationRepository extends JpaRepository<QuadraticEquation, UUID> {
}

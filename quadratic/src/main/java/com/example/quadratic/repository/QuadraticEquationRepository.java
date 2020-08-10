package com.example.quadratic.repository;

import com.example.quadratic.model.QuadraticEquation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Kostya Krivonos
 * 2/4/19
 * 3:47 PM
 */

@Component
public interface QuadraticEquationRepository extends JpaRepository<QuadraticEquation, Integer> {

    List<QuadraticEquation> findAll();

    @Query(value = "select * from equation where equation.a = :a and equation.b = :b and equation.c = :c", nativeQuery = true)
    QuadraticEquation findByABC(@Param(value = "a") double a, @Param(value = "b") double b, @Param(value = "c") double c);
}

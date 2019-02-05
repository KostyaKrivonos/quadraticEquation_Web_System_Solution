package com.example.quadratic.quadratic.repository;

import com.example.quadratic.quadratic.model.QuadraticEquation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/**
 * Kostya Krivonos
 * 2/4/19
 * 3:47 PM
 */

@Component
public interface QuadraticEquationRepository extends JpaRepository<QuadraticEquation, Integer> {

    @Query(value = "select * from equation where equation.a = :a and equation.b = :b and equation.c = :c", nativeQuery = true)
    QuadraticEquation findByABC(@Param(value = "a")double a, @Param(value = "b")double b, @Param(value = "c")double c);
}

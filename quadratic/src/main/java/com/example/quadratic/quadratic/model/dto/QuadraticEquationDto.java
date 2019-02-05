package com.example.quadratic.quadratic.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * Kostya Krivonos
 * 2/4/19
 * 5:38 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuadraticEquationDto {
    private int id;

    private double a;

    private double b;

    private double c;

    private double D;

    private double x1;

    private double x2;

}

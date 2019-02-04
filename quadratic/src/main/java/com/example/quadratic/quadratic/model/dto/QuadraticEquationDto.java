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
@Entity
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

    public QuadraticEquationDto(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquationDto(double a, double b, double c, double D, double x1, double x2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.D = D;
        this.x1 = x1;
        this.x2 = x2;
    }

    public QuadraticEquationDto(double a, double b, double c, double D, double x1) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.D = D;
        this.x1 = x1;
    }
}

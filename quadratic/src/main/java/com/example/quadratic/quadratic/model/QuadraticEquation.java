package com.example.quadratic.quadratic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Kostya Krivonos
 * 2/4/19
 * 3:42 PM
 */


@Entity
@Table(name = "equation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuadraticEquation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private double a;

    @Column(nullable = false)
    private double b;

    @Column(nullable = false)
    private double c;

    @Column(nullable = false)
    private double D;

    @Column(nullable = false)
    private double x1;

    @Column(nullable = false)
    private double x2;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation(double a, double b, double c, double D, double x1, double x2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.D = D;
        this.x1 = x1;
        this.x2 = x2;
    }

    public QuadraticEquation(double a, double b, double c, double D, double x1) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.D = D;
        this.x1 = x1;
    }
}

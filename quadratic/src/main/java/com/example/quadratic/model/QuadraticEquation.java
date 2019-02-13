package com.example.quadratic.model;

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
    private Double a;

    @Column(nullable = false)
    private Double b;

    @Column(nullable = false)
    private Double c;

    @Column(nullable = false)
    private Double D;

    @Column
    private Double x1;

    @Column
    private Double x2;

    public QuadraticEquation(Double a, Double b, Double c, Double D, Double x1, Double x2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.D = D;
        this.x1 = x1;
        this.x2 = x2;
    }

    public QuadraticEquation(Double a, Double b, Double c, Double D, Double x1) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.D = D;
        this.x1 = x1;
    }
}

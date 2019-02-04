package com.example.quadratic.quadratic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Kostya Krivonos
 * 2/4/19
 * 3:42 PM
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class QuadraticEquation {
    @Id
    private UUID id;

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
}

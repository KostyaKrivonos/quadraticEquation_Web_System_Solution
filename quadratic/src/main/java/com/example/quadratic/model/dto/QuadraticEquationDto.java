package com.example.quadratic.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Kostya Krivonos
 * 2/4/19
 * 5:38 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuadraticEquationDto {
    private Integer id;

    private Double a;

    private Double b;

    private Double c;

    private Double D;

    private Double x1;

    private Double x2;

}

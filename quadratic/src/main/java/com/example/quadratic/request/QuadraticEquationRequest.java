package com.example.quadratic.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuadraticEquationRequest {

    private Double a;

    private Double b;

    private Double c;
}

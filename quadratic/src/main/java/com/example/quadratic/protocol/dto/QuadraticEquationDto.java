package com.example.quadratic.protocol.dto;


import com.example.quadratic.model.QuadraticEquation;
import com.example.quadratic.request.QuadraticEquationRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class QuadraticEquationDto {
    private Integer id;

    private Double a;

    private Double b;

    private Double c;

    private Double D;

    private Double x1;

    private Double x2;

    public static QuadraticEquationDto convertToDto(QuadraticEquationRequest quadraticEquation){
        return QuadraticEquationDto.builder()
                .a(quadraticEquation.getA())
                .b(quadraticEquation.getB())
                .c(quadraticEquation.getC())
                .build();
    }
}

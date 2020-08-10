package com.example.quadratic.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuadraticEquationRequest {

    @NonNull
    private Double a;
    @NonNull
    private Double b;
    @NonNull
    private Double c;
}

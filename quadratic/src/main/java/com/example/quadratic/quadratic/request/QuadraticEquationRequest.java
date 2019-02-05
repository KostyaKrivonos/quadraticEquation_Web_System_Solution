package com.example.quadratic.quadratic.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuadraticEquationRequest {

    @NonNull
    private double a;

    @NonNull
    private double b;

    @NonNull
    private double c;
}

package com.example.quadratic.service.api;

import com.example.quadratic.protocol.dto.QuadraticEquationDto;
import com.example.quadratic.request.QuadraticEquationRequest;

import java.util.List;

public interface QuadraticEquationService {

    QuadraticEquationDto calculate(QuadraticEquationRequest equationRequest);

    List<QuadraticEquationDto> getAll();
}

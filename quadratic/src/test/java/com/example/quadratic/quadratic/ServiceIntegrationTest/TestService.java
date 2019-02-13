package com.example.quadratic.quadratic.ServiceIntegrationTest;

import com.example.quadratic.controller.EquationController;
import com.example.quadratic.exception.NoSolutionEquationException;
import com.example.quadratic.model.dto.QuadraticEquationDto;
import com.example.quadratic.request.QuadraticEquationRequest;
import com.example.quadratic.service.QuadraticEquationService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Kostya Krivonos
 * 13.02.19
 */

public class TestService {
    private EquationController equationController;

    @Before
    public void setup() {
        QuadraticEquationService equationService = mock(QuadraticEquationService.class);
        equationController = new EquationController(equationService);

    }

    @Test
    public void testCalculation_ResponseOk() {
        QuadraticEquationService equationService = mock(QuadraticEquationService.class);
        QuadraticEquationRequest equationRequest = new QuadraticEquationRequest();
        equationRequest.setA(1.0);
        equationRequest.setB(-13.0);
        equationRequest.setC(36.0);
        when(equationService.calculate(equationRequest)).thenReturn(HttpStatus.OK);
        HttpStatus status = equationService.calculate(equationRequest);
        assertThat(HttpStatus.OK)
                .isEqualTo(status);
    }

    @Test
    public void testCalculation_NoRootException() {
        QuadraticEquationService equationService = mock(QuadraticEquationService.class);
        QuadraticEquationRequest equationRequest = new QuadraticEquationRequest();
        equationRequest.setA(0.0);
        equationRequest.setB(0.0);
        equationRequest.setC(36.0);
        when(equationService.calculate(equationRequest)).thenThrow(new NoSolutionEquationException());
    }

    @Test

    public void testGetAll_returnListQuadraticEquationDto() {
        QuadraticEquationService equationService = mock(QuadraticEquationService.class);
        List<QuadraticEquationDto> equationDtos = new ArrayList<>();
        when(equationService.getAll()).thenReturn(equationDtos);
        assertThat(equationService.getAll())
                .isEqualTo(equationDtos);
    }
}

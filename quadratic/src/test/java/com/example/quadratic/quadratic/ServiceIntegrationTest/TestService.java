package com.example.quadratic.quadratic.ServiceIntegrationTest;

import com.example.quadratic.model.dto.QuadraticEquationDto;
import com.example.quadratic.repository.QuadraticEquationRepository;
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
    private QuadraticEquationService equationService;

    @Before
    public void setup() {
        QuadraticEquationRepository equationRepository = mock(QuadraticEquationRepository.class);
        equationService = new QuadraticEquationService (equationRepository);

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
    public void testCalculationoSolution_BadRequest() {
        QuadraticEquationService equationService = mock(QuadraticEquationService.class);
        QuadraticEquationRequest equationRequest = new QuadraticEquationRequest();
        equationRequest.setA(0.0);
        equationRequest.setB(0.0);
        equationRequest.setC(36.0);
        when(equationService.calculate(equationRequest)).thenReturn(HttpStatus.BAD_REQUEST);
        HttpStatus status = equationService.calculate(equationRequest);
        assertThat(HttpStatus.BAD_REQUEST)
                .isEqualTo(status);
    }

    @Test
    public void testCalculationEnterNull_BadRequest() {
        QuadraticEquationService equationService = mock(QuadraticEquationService.class);
        QuadraticEquationRequest equationRequest = new QuadraticEquationRequest();
        equationRequest.setA(null);
        equationRequest.setB(null);
        equationRequest.setC(null);
        when(equationService.calculate(equationRequest)).thenReturn(HttpStatus.BAD_REQUEST);
        HttpStatus status = equationService.calculate(equationRequest);
        assertThat(HttpStatus.BAD_REQUEST)
                .isEqualTo(status);
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

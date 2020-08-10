//package com.example.quadratic.quadratic.ServiceIntegrationTest;
//
//import com.example.quadratic.model.QuadraticEquation;
//import com.example.quadratic.protocol.dto.QuadraticEquationDto;
//import com.example.quadratic.repository.QuadraticEquationRepository;
//import com.example.quadratic.request.QuadraticEquationRequest;
//import com.example.quadratic.service.impl.QuadraticEquationServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
///**
// * Kostya Krivonos
// * 13.02.19
// */
//
//@RunWith(SpringRunner.class)
//public class QuadraticEquationServiceTest {
//    @Mock
//    private QuadraticEquationRepository equationRepository;
//
//    @InjectMocks
//    private QuadraticEquationServiceImpl equationService;
//
//    private QuadraticEquationRequest equationRequest;
//    ;
//
//    private QuadraticEquationDto quadraticEquationDto;
//
//    @Before
//    public void setup() {
//        equationRequest = new QuadraticEquationRequest();
//        equationRequest.setA(1.0);
//        equationRequest.setB(-13.0);
//        equationRequest.setC(36.0);
//        quadraticEquationDto = QuadraticEquationDto.convertToDto(equationRequest);
//
//    }
//
//    @Test
//    public void testCalculation_ResponseOk() {
//        when(equationService.calculate(equationRequest)).thenReturn(quadraticEquationDto);
//        QuadraticEquationDto dto = equationService.calculate(equationRequest);
//        assertThat(dto)
//                .isEqualTo(quadraticEquationDto);
//    }
//
//    @Test
//    public void testGetAll_returnListQuadraticEquationDto() {
//        QuadraticEquationServiceImpl equationService = mock(QuadraticEquationServiceImpl.class);
//        List<QuadraticEquationDto> equationDtos = Arrays.asList(quadraticEquationDto);
//        when(equationRepository.findAll()).thenReturn(Arrays.asList(new QuadraticEquation()));
//        assertThat(equationService.getAll())
//                .isEqualTo(equationDtos);
//    }
//}

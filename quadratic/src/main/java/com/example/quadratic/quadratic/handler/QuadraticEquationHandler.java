package com.example.quadratic.quadratic.handler;

import com.example.quadratic.quadratic.exception.NoRootEquationException;
import com.example.quadratic.quadratic.model.QuadraticEquation;
import com.example.quadratic.quadratic.model.dto.QuadraticEquationDto;
import com.example.quadratic.quadratic.request.QuadraticEquationRequest;
import com.example.quadratic.quadratic.service.QuadraticEquationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class QuadraticEquationHandler {
    @Autowired
    private QuadraticEquationService quadraticEquationService;
    @Autowired
    private ModelMapper modelMapper;


    public ResponseEntity<QuadraticEquationDto> calculate(QuadraticEquationRequest request) {
        QuadraticEquation quadraticEquation = quadraticEquationService.check(request.getA(), request.getB(), request.getC());// check for the existence of an equation
        if (quadraticEquation == null) {
            double a, b, c, D;
            double x1, x2;
            a = request.getA();
            b = request.getB();
            c = request.getC();
            D = b * b - 4 * a * c;

            if (D > 0) {
                x1 = (-b + Math.sqrt(D)) / (2 * a);
                x2 = (-b - Math.sqrt(D)) / (2 * a);
                log.info("Equation has two roots: x1 = [{}], x2 = [{}]", x1, x2);
                QuadraticEquation equationTwoRoots = quadraticEquationService.save(new QuadraticEquation(a, b, c, D, x1, x2));
                return ResponseEntity.ok(modelMapper.map(equationTwoRoots, QuadraticEquationDto.class));
            }
            if (D == 0) {
                x1 = -b / (2 * a);
                log.info("Equation has one roots: x1 = [{}]", x1);
                QuadraticEquation equationOneRoots = quadraticEquationService.save(new QuadraticEquation(a, b, c, D, x1));
                return ResponseEntity.ok(modelMapper.map(equationOneRoots, QuadraticEquationDto.class));
            } else throw new NoRootEquationException();
        } else
            return ResponseEntity.ok(modelMapper.map(quadraticEquation, QuadraticEquationDto.class));
    }

    public List<QuadraticEquationDto> getAll() {
        List<QuadraticEquationDto> equationDtos = new ArrayList<>();
        List<QuadraticEquation> equations = quadraticEquationService.findAll();
        for (QuadraticEquation equation : equations) {
            QuadraticEquationDto dto = modelMapper.map(equation, QuadraticEquationDto.class);
            equationDtos.add(dto);
        }
        return equationDtos;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

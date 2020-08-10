package com.example.quadratic.service.impl;

import com.example.quadratic.exception.NoSolutionEquationException;
import com.example.quadratic.model.QuadraticEquation;
import com.example.quadratic.protocol.dto.QuadraticEquationDto;
import com.example.quadratic.repository.QuadraticEquationRepository;
import com.example.quadratic.request.QuadraticEquationRequest;
import com.example.quadratic.service.api.QuadraticEquationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class QuadraticEquationServiceImpl implements QuadraticEquationService {
    private QuadraticEquationRepository quadraticEquationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public QuadraticEquationServiceImpl(QuadraticEquationRepository quadraticEquationRepository) {
        this.quadraticEquationRepository = quadraticEquationRepository;
    }

    public QuadraticEquationDto calculate(QuadraticEquationRequest equationRequest) {
        QuadraticEquation quadraticEquation = quadraticEquationRepository.findByABC(equationRequest.getA(), equationRequest.getB(), equationRequest.getC());// check for the existence of an equation
        QuadraticEquation equation = null;
        if (quadraticEquation == null) {
            Double x1, x2;
            Double a = equationRequest.getA();
            Double b = equationRequest.getB();
            Double c = equationRequest.getC();
            Double D = calculationDiscriminant(a, b, c);
            if (D > 0) {
                x1 = calculationX1ByDiscriminant(D, a, b);
                x2 = (-b - Math.sqrt(D)) / (2 * a);
                if (checkOnInfinityOrNaNTwoRoots(x1, x2)) {
                    log.info("[x] [D > 0] Equation has two roots: x1 = [{}], x2 = [{}]", x1, x2);
                    equation = new QuadraticEquation(a, b, c, D, x1, x2);
                    quadraticEquationRepository.save(equation);
                    return modelMapper.map(equation, QuadraticEquationDto.class);
                } else throw new NoSolutionEquationException();
            }
            if (D == 0) {
                x1 = calculationX1ByDiscriminant(D, a, b);
                if (checkOnInfinityOrNaNOneRoot(x1)) {
                    log.info("[x] [D == 0] Equation has one roots: x1 = [{}]", x1);
                    equation = new QuadraticEquation(a, b, c, D, x1);
                    quadraticEquationRepository.save(equation);
                    return modelMapper.map(equation, QuadraticEquationDto.class);
                } else throw new NoSolutionEquationException();
            } else throw new NoSolutionEquationException();
        } else
            log.info("[x] Equation is present: [{}]", quadraticEquation);
        return modelMapper.map(quadraticEquation, QuadraticEquationDto.class);
    }

    public List<QuadraticEquationDto> getAll() {
        List<QuadraticEquationDto> equationDtos = new ArrayList<>();
        List<QuadraticEquation> equations = quadraticEquationRepository.findAll();
        log.info("[x] Got all Quadratic Equation.");
        for (QuadraticEquation equation : equations) {
            QuadraticEquationDto dto = modelMapper.map(equation, QuadraticEquationDto.class);
            equationDtos.add(dto);
        }
        return equationDtos;
    }

    private Double calculationDiscriminant(Double a, Double b, Double c) {
        Double D = b * b - 4 * a * c;
        log.info("[x] Got discriminant [{}].", D.toString());
        return D;
    }

    private Double calculationX1ByDiscriminant(Double D, Double a, Double b) {
        if (D > 0) {
            return (-b + Math.sqrt(D)) / (2 * a);
        } else if (D == 0) {
            return -b / (2 * a);
        } else throw new NoSolutionEquationException();
    }

    private boolean checkOnInfinityOrNaNTwoRoots(Double x1, Double x2) {
        List<Double> roots = new ArrayList<>();
        if (x1.isInfinite() || x1.isNaN() && x2.isInfinite() || x2.isNaN())
            log.info("[x] x1 is [{}], x2 is [{}].", x1, x2);
        return false;
    }

    private boolean checkOnInfinityOrNaNOneRoot(Double x1) {
        if (x1.isInfinite() || x1.isNaN())
            log.info("[x] x1 is [{}].", x1);
        return false;
    }
}

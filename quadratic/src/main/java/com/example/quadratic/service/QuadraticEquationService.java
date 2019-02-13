package com.example.quadratic.service;

import com.example.quadratic.exception.NoSolutionEquationException;
import com.example.quadratic.model.QuadraticEquation;
import com.example.quadratic.model.dto.QuadraticEquationDto;
import com.example.quadratic.repository.QuadraticEquationRepository;
import com.example.quadratic.request.QuadraticEquationRequest;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class QuadraticEquationService {

    private QuadraticEquationRepository quadraticEquationRepository;

    private ModelMapper modelMapper;

    @Autowired
    public QuadraticEquationService(QuadraticEquationRepository quadraticEquationRepository) {
        this.quadraticEquationRepository = quadraticEquationRepository;
    }

    public HttpStatus calculate(QuadraticEquationRequest request) {

        QuadraticEquation quadraticEquation = quadraticEquationRepository.findByABC(request.getA(), request.getB(), request.getC());// check for the existence of an equation
        if (quadraticEquation == null) {
            Double a, b, c, D;
            Double x1, x2;
            a = request.getA();
            b = request.getB();
            c = request.getC();
            D = b * b - 4 * a * c;

            if (D > 0) {
                x1 = (-b + Math.sqrt(D)) / (2 * a);
                x2 = (-b - Math.sqrt(D)) / (2 * a);
                checkOnInfinityOrNaNTwoRoots(x1, x2);
                log.info("[x] [D > 0] Equation has two roots: x1 = [{}], x2 = [{}]", x1, x2);
                quadraticEquationRepository.save(new QuadraticEquation(a, b, c, D, x1, x2));
                return HttpStatus.OK;
            }
            if (D == 0) {
                x1 = -b / (2 * a);
                checkOnInfinityOrNaNOneRoot(x1);
                log.info("[x] [D == 0] Equation has one roots: x1 = [{}]", x1);
                quadraticEquationRepository.save(new QuadraticEquation(a, b, c, D, x1));
                return HttpStatus.OK;
            } else throw new NoSolutionEquationException();
        } else
            log.info("[x] Equation is present: [{}]", quadraticEquation);
        return HttpStatus.OK;
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

    private List<Double> checkOnInfinityOrNaNTwoRoots(Double x1, Double x2) {
        List<Double> roots = new ArrayList<>();
        if (x1.isInfinite() || x1.isNaN() && x2.isInfinite() || x2.isNaN()) {
            log.info("[x] x1 is [{}], x2 is [{}].", x1, x2);
            throw new NoSolutionEquationException();
        } else roots.add(x1);
        roots.add(x2);
        return roots;
    }

    private Double checkOnInfinityOrNaNOneRoot(Double x1) {
        if (x1.isInfinite() || x1.isNaN()) {
            log.info("[x] x1 is [{}].", x1);
            throw new NoSolutionEquationException();
        } else
            return x1;
    }
}

package com.example.quadratic.service;

import com.example.quadratic.exception.InfinityOrNaNException;
import com.example.quadratic.exception.NoRootEquationException;
import com.example.quadratic.exception.NotFoundEquationException;
import com.example.quadratic.model.QuadraticEquation;
import com.example.quadratic.model.dto.QuadraticEquationDto;
import com.example.quadratic.repository.QuadraticEquationRepository;
import com.example.quadratic.request.QuadraticEquationRequest;
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
public class QuadraticEquationService {
    @Autowired
    private QuadraticEquationRepository quadraticEquationRepository;
    @Autowired
    private ModelMapper modelMapper;


    public ResponseEntity<QuadraticEquationDto> calculate(QuadraticEquationRequest request) {

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
                List<Double> roots = checkOnInfinityOrNaN(x1,x2);
                log.info("[x] [D > 0] Equation has two roots: x1 = [{}], x2 = [{}]", roots.get(0), roots.get(1));
                QuadraticEquation equationTwoRoots = quadraticEquationRepository.save(new QuadraticEquation(a, b, c, D, roots.get(0), roots.get(1)));
                return ResponseEntity.ok(modelMapper.map(equationTwoRoots, QuadraticEquationDto.class));
            }
            if (D == 0) {
                x1 = -b / (2 * a);
                log.info("[x] [D == 0] Equation has one roots: x1 = [{}]", x1);
                QuadraticEquation equationOneRoots = quadraticEquationRepository.save(new QuadraticEquation(a, b, c, D, x1));
                return ResponseEntity.ok(modelMapper.map(equationOneRoots, QuadraticEquationDto.class));
            }
            if (D < 0) {
                D = D / 2;
                x1 = (-b + Math.sqrt(D)) / 2 * a;
                x2 = (-b - Math.sqrt(D)) / 2 * a;
                List<Double> roots = checkOnInfinityOrNaN(x1,x2);
                log.info("[x] [D < 0] Equation has complex roots: x1 = [{}], x1 = [{}], ", roots.get(0), roots.get(1));
                QuadraticEquation equationOneRoots = quadraticEquationRepository.save(new QuadraticEquation(a, b, c, D, roots.get(0), roots.get(1)));
                return ResponseEntity.ok(modelMapper.map(equationOneRoots, QuadraticEquationDto.class));
            } else throw new NoRootEquationException();
        } else
            return ResponseEntity.ok(modelMapper.map(quadraticEquation, QuadraticEquationDto.class));
    }

    public List<QuadraticEquationDto> getAll() {
        List<QuadraticEquationDto> equationDtos = new ArrayList<>();
        List<QuadraticEquation> equations = quadraticEquationRepository.findAll();
        log.info("[x] Got all Quadratic Equation.");
        if (equations != null) {
            for (QuadraticEquation equation : equations) {
                QuadraticEquationDto dto = modelMapper.map(equation, QuadraticEquationDto.class);
                equationDtos.add(dto);
            }
            return equationDtos;
        } else throw new NotFoundEquationException();
    }

    private List<Double> checkOnInfinityOrNaN(Double x1, Double x2) {
        List<Double> roots = new ArrayList<>();
        if (x1.isInfinite() || x1.isNaN() && x2.isInfinite() || x2.isNaN()) {
            throw new InfinityOrNaNException();
        } else roots.add(x1);
        roots.add(x2);
        return roots;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

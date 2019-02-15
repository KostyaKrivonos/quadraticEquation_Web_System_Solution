package com.example.quadratic.controller;


import com.example.quadratic.request.QuadraticEquationRequest;
import com.example.quadratic.service.QuadraticEquationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@ComponentScan
public class EquationController {

    private QuadraticEquationService quadraticEquationService;

    @Value("${message.error}")
    private String errorMessage;

    @Autowired
    public EquationController(QuadraticEquationService quadraticEquationService) {
        this.quadraticEquationService = quadraticEquationService;
    }

    @PostMapping(value = "/calculation")
    public String calculation(@Valid Model model, @ModelAttribute("equationRequest") QuadraticEquationRequest equationRequest) {
        Double a = equationRequest.getA();
        Double b = equationRequest.getB();
        Double c = equationRequest.getC();

        if (a != null && b != null && c != null) {
            HttpStatus status = quadraticEquationService.calculate(equationRequest);
            if (!status.is4xxClientError()) {
                quadraticEquationService.calculate(equationRequest);
                return "redirect:/all";
            } else {
                model.addAttribute("errorMessage", errorMessage);
                return "calculation";
            }
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "calculation";
        }
    }

    @GetMapping(value = "/all")
    public String getAllEquation(Model model) {
        model.addAttribute("equations", quadraticEquationService.getAll());
        return "allEquation";
    }

    @GetMapping(value = {"/calculation"})
    public String showCalculation(Model model) {

        QuadraticEquationRequest equationRequest = new QuadraticEquationRequest();
        model.addAttribute("equationRequest", equationRequest);

        return "calculation";
    }
}

package com.example.quadratic.controller;


import com.example.quadratic.model.QuadraticEquation;
import com.example.quadratic.request.QuadraticEquationRequest;
import com.example.quadratic.service.QuadraticEquationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@ComponentScan
public class EquationController {

    private QuadraticEquationService quadraticEquationService;

    @Autowired
    public EquationController(QuadraticEquationService quadraticEquationService) {
        this.quadraticEquationService = quadraticEquationService;
    }

    private static List<QuadraticEquation> equations = new ArrayList<>();

    @PostMapping(value = "/calculation")
    public String calculation(@Valid Model model, @ModelAttribute("equationRequest") QuadraticEquationRequest equationRequest) {
        quadraticEquationService.calculate(equationRequest);
        return "redirect:/all";
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

package com.example.quadratic.quadratic.controller;


import com.example.quadratic.quadratic.form.QuadraticEquationForm;
import com.example.quadratic.quadratic.handler.QuadraticEquationHandler;
import com.example.quadratic.quadratic.model.QuadraticEquation;
import com.example.quadratic.quadratic.request.QuadraticEquationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@ComponentScan
//@RequestMapping("/equations")
public class EquationController {
    @Autowired
    private QuadraticEquationHandler quadraticEquationHandler;

    private static List<QuadraticEquation> equations = new ArrayList<>();

    @RequestMapping(value = "/calculation", method = RequestMethod.POST)
    public String calculation(@Valid Model model, @ModelAttribute("equationForm") QuadraticEquationForm equationForm) {
        QuadraticEquationRequest request = new QuadraticEquationRequest(equationForm.getA(), equationForm.getB(), equationForm.getC());
        quadraticEquationHandler.calculate(request);
        return "redirect:/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllEquation(Model model) {
        model.addAttribute("equations", quadraticEquationHandler.getAll());
        return "allEquation";
    }

    @RequestMapping(value = { "/calculation" }, method = RequestMethod.GET)
    public String showCalculation(Model model) {

        QuadraticEquationForm equationForm = new QuadraticEquationForm();
        model.addAttribute("equationForm", equationForm);

        return "calculation";
    }
}

package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public String calculate(Model model,
                            @RequestParam(value = "firstNumber", required = false) String firstNumber,
                            @RequestParam(value = "secondNumber", required = false) String secondNumber,
                            @RequestParam(value = "operator", required = false) String operator) {
        if (firstNumber != null && secondNumber != null && operator != null) {
            double num1 = Double.parseDouble(firstNumber);
            double num2 = Double.parseDouble(secondNumber);
            double result = 0;
            switch (operator) {
                case "add":
                    result = num1 + num2;
                    break;
                case "subtract":
                    result = num1 - num2;
                    break;
                case "multiply":
                    result = num1 * num2;
                    break;
                case "divide":
                    result = num1 / num2;
                    break;
            }
            model.addAttribute("result", result);
        }
        return "calculator";
    }
}

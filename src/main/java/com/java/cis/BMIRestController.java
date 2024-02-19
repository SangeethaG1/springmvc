package com.java.cis;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMIRestController {

    @PostMapping("/bmirest")
    public String calculateBMI(@RequestParam("height") double height, @RequestParam("weight") double weight) {
        // Calculate BMI
        double bmi = calculateBMIUsingFormula(height, weight);

        // Create a JSON object with BMI value
        String jsonResponse = "{\"bmi\": " + bmi + "}";

        return jsonResponse;
    }

    // BMI Calculation Formula
    private double calculateBMIUsingFormula(double height, double weight) {
        // Convert height to meters
        double bmi = Math.round((weight / (height * height) * 703)*100)/100.0;

        // Calculate BMI using the formula: weight (kg) / (height (m) * height (m))
        return bmi;
    }
}

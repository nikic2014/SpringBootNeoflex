package com.example.VacationPayCalculator.controller;

import com.example.VacationPayCalculator.servise.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;


@Controller
public class HomeController {
    @GetMapping("/calculate")
    public @ResponseBody double getVacationPay(@RequestParam("salary") double salary,
                                               @RequestParam("countDay") int countDay) {
        return Calculator.simpleCalculate(salary, countDay);
    }
    // http://localhost:8080/calculate?salary=150000&countDay=2

    @GetMapping("/calculateDays")
    public @ResponseBody String getVacationPay(@RequestParam("salary") double salary,
                                               @RequestParam("startDate") LocalDate startDate,
                                               @RequestParam("endDate") LocalDate endDate) {
        try {
            return String.valueOf(Calculator.complexCalculate(salary,
                    startDate, endDate));
        }
        catch (Error e) {
            return "Введены некорректные данные";
        }
    }
    //http://localhost:8080/calculateDays?salary=150000&startDate=2001-09-11&endDate=2001-12-12
}
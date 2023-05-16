package com.example.VacationPayCalculator.servise;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void simpleCalculate() {
        assertEquals(0, Calculator.simpleCalculate(150000, 0));
        assertEquals(426.6211604095563, Calculator.simpleCalculate(150000, 1));
        assertEquals(853.2423208191126, Calculator.simpleCalculate(150000, 2));
        assertEquals(1279.863481228669, Calculator.simpleCalculate(150000, 3));
        assertEquals(1706.4846416382252, Calculator.simpleCalculate(150000, 4));
        assertEquals(2133.1058020477813, Calculator.simpleCalculate(150000, 5));
        assertEquals(4266.2116040955625, Calculator.simpleCalculate(150000, 10));
        assertEquals(8532.423208191125, Calculator.simpleCalculate(150000, 20));
        assertEquals(12798.63481228669, Calculator.simpleCalculate(150000, 30));
        assertEquals(426621.1604095563, Calculator.simpleCalculate(150000,
                1000));
        assertEquals(4.266211604095563E7, Calculator.simpleCalculate(15000000,
                1000));
    }

    @Test
    void complexCalculate() {
        assertEquals(426.6211604095563, Calculator.complexCalculate(150000,
                LocalDate.of(2001, 9, 11),
                LocalDate.of(2001, 9, 12)));
        assertEquals(853.2423208191126, Calculator.complexCalculate(150000,
                LocalDate.of(2001, 9, 11),
                LocalDate.of(2001, 9, 13)));
        assertEquals(1279.863481228669, Calculator.complexCalculate(150000,
                LocalDate.of(2001, 9, 11),
                LocalDate.of(2001, 9, 14)));
        assertEquals(1279.863481228669, Calculator.complexCalculate(150000,
                LocalDate.of(2001, 9, 11),
                LocalDate.of(2001, 9, 15)));
        assertEquals(1279.863481228669, Calculator.complexCalculate(150000,
                LocalDate.of(2001, 9, 11),
                LocalDate.of(2001, 9, 16)));
        assertEquals(1706.4846416382252, Calculator.complexCalculate(150000,
                LocalDate.of(2001, 9, 11),
                LocalDate.of(2001, 9, 17)));
        assertEquals(5546.075085324232, Calculator.complexCalculate(150000,
                LocalDate.of(2001, 9, 11),
                LocalDate.of(2001, 9, 29)));
        assertEquals(33276.45051194539, Calculator.complexCalculate(150000,
                LocalDate.of(2001, 9, 11),
                LocalDate.of(2002, 1, 1)));
        assertEquals(33276.45051194539, Calculator.complexCalculate(150000,
                LocalDate.of(2001, 9, 11),
                LocalDate.of(2002, 1, 10)));
    }
}
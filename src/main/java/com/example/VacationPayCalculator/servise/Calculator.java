package com.example.VacationPayCalculator.servise;

import java.time.LocalDate;
import static com.example.VacationPayCalculator.servise.MyСalendar.getCountWorkDay;

public class Calculator {
    public static double simpleCalculate(double salary, int countDay) {
        return salary / 12 / 29.3 * countDay;
    }

    public static double complexCalculate(double salary,
                                          LocalDate startDate,
                                          LocalDate endDate) {
        return salary / 12 / 29.3 * getCountWorkDay(startDate,
                endDate);
    }
}

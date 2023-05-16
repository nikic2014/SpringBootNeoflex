package com.example.VacationPayCalculator.servise;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

public class MyСalendar {
    public static int getCountNotWorkDay(LocalDate s, LocalDate e) {
        int sYear = s.getYear();
        int eYear = e.getYear();

        if (s.isAfter(e))
            throw new Error("Дата начала позже даты конца");

        ArrayList<LocalDate> holiday = new ArrayList<>();
        getListHoliday(holiday, sYear);

        for (int i = sYear + 1; i <= eYear; i++)
            getListHoliday(holiday, i);

        int countHolidayholiday =
                holiday.stream().filter(x ->
                        (!s.isAfter(x) && !e.isBefore(x))).toList().size();

        int ans = 0;
        long endDay = e.toEpochDay();
        long startDay = s.toEpochDay();

        LocalDate test =
                LocalDate.ofEpochDay(startDay + (endDay - startDay + 1) / 7 * 7);
        while(!test.isAfter(e)){
            DayOfWeek dayOfweek = DayOfWeek.from(test);
            if (dayOfweek == DayOfWeek.SUNDAY || dayOfweek == DayOfWeek.SATURDAY) {
                ans++;
            }
            test = test.plusDays(1);
        }

        /*
        * Так как обычно, если праздники выпадают на выходной, то их
        * переносят, будем считать, сумму нерабочих дней, как выходные +
        * количество праздников, выпавших в наш промежуток дат.
        */

        ans += (endDay - startDay + 1) / 7 * 2;
        return countHolidayholiday + ans;
    }

    public static long getCountWorkDay(LocalDate s, LocalDate e) {
        return e.toEpochDay() - s.toEpochDay() - getCountNotWorkDay(s, e);
    }

    public static ArrayList<LocalDate> getListHoliday(ArrayList<LocalDate> lst,
                                                      int year) {

        // Добавленны самые популярные празники в России

        lst.addAll(Stream.of(LocalDate.of(year, 1, 1),
                LocalDate.of(year, 1, 2),
                LocalDate.of(year, 1, 3),
                LocalDate.of(year, 1, 4),
                LocalDate.of(year, 1, 5),
                LocalDate.of(year, 1, 6),
                LocalDate.of(year, 1, 7),
                LocalDate.of(year, 1, 8),
                LocalDate.of(year, 2, 23),
                LocalDate.of(year, 3, 8),
                LocalDate.of(year, 5, 1),
                LocalDate.of(year, 5, 9),
                LocalDate.of(year, 6, 12),
                LocalDate.of(year, 12, 31)
        ).toList());
        return lst;
    }
}

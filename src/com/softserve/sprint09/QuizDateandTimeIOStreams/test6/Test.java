package com.softserve.sprint09.QuizDateandTimeIOStreams.test6;

import java.time.LocalDate;
import java.time.Month;

/**
 * What will be the output of the following program?
 *
 * a. 2017-11-08   <-- V LocalDate is immutable
 * b. Runtime error
 * c. 61468236000000
 * d. Compile error
 * e. 2020-02-12
 */
public class Test {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2017, Month.NOVEMBER, 8);
        date.plusYears(2).plusMonths(3).plusDays(4);
        System.out.println(date);
    }
}

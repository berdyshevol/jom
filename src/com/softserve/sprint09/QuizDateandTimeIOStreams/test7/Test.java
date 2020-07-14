package com.softserve.sprint09.QuizDateandTimeIOStreams.test7;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * What will be the output of the following program?
 * a. Compile error
 * b. 2017-11-08
 * c. 2017-11-10
 * d. 61468236000000
 * e. Runtime error <- V "UnsupportedTemporalTypeException: Unsupported unit: Hours"
 *
 */
public class Test {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2017, Month.NOVEMBER, 8);
        date = date.plus(48, ChronoUnit.HOURS);
        System.out.println(date);
    }
}

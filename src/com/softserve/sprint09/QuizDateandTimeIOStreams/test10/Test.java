package com.softserve.sprint09.QuizDateandTimeIOStreams.test10;

import java.time.LocalDateTime;
import java.time.Period;

/**
 * What will be the output of the following program?
 * a. Runtime error
 * b. 2017-11-23T15:38 // <-- V
 * c. Compile errror
 * d. 2017-11-26T15:38
 * e. 2016-09-23T15:38
 */
public class Test {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2017, 11, 26, 15, 38);
        Period period = Period.ofYears(1).ofMonths(2).ofDays(3);
        dateTime = dateTime.minus(period);
        System.out.println(dateTime); // 2017-11-23T15:38
    }
}

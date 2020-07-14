package com.softserve.sprint09.QuizDateandTimeIOStreams.test8;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * What will be the output of the following program?
 * a. Nov 8, 2017, 3:38:00 PM
 * b. Runtime error
 * c. 11/8/17, 3:38 PM
 * d. Compile error
 * e. 2017-11-08T15:38
 */

public class Test {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2017, Month.NOVEMBER, 8, 15, 38);
        String dateTime = localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        System.out.println(dateTime); // Nov 8, 2017
    }
}

package com.softserve.sprint09.QuizDateandTimeIOStreams.test4;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * What will be the output of the following program?
 *  a. 8.0.2018  <-- V
 *  b. 8.12.2017
 *  c. Compile error
 *  d. 08.12.2017
 */
public class Test {
    public static void main(String[] args) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 12);
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "."); // 8.
        System.out.print(calendar.get(Calendar.MONTH) + ".");        // 0.
        System.out.print(calendar.get(Calendar.YEAR));               // 2017
    }
}

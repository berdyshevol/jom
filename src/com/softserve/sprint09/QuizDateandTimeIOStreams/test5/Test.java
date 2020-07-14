package com.softserve.sprint09.QuizDateandTimeIOStreams.test5;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Which of the following correctly creates an instance of LocalDateTime class?
 *
 * Select one or more:
 * a. LocalDateTime dt1 = new LocalDateTime(2017, Month.NOVEMBER, 8, 15, 38);
 * b. LocalDateTime ld = LocalDateTime.of(2017, Month.NOVEMBER, 8, 15, 38);   <-- ok
 * c. LocalDateTime ld1 = new LocalDateTime();
 * d. LocalDateTime ld1 = LocalDateTime.of(2017, Month.NOVEMBER, 8);
 * e. LocalDateTime ld1 = LocalDateTime.now();                                <-- ok
 *
 */
public class Test {
    public static void main(String[] args) {
//        LocalDateTime dt1 = new LocalDateTime(2017, Month.NOVEMBER, 8, 15, 38);
        LocalDateTime ld = LocalDateTime.of(2017, Month.NOVEMBER, 8, 15, 38);
//        LocalDateTime ld1 = new LocalDateTime();
//        LocalDateTime ld1 = LocalDateTime.of(2017, Month.NOVEMBER, 8);
        LocalDateTime ld1 = LocalDateTime.now();
    }
}

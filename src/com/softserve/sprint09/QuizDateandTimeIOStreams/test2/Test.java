package com.softserve.sprint09.QuizDateandTimeIOStreams.test2;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
//        Which of the following correctly creates an instance of Date class?

        Date date = new Date(); // <-- V
//        Date d1 = Date.now();
//        Date d2 = Date.of(24356667777);
        Date d1 = new Date(20000000); // <-- V
//        Date d2 = System.currentTimeMillis();
    }
}

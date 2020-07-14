package com.softserve.sprint09.QuizStreamAPI.test14;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

/**
 * What will be the result of the following code?
 *
 *
 * Select one or more:
 * a. Compile Error
 * b. 6  <-- V
 * c. 4  <-- V
 * d. 7
 * e. 5  <-- V
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(
                Stream.generate( () -> random.nextInt(7)) // random 0..6
                .limit(4)
                .max(Comparator.naturalOrder()) // max <= 6
                .orElse(6)
        );
    }
}

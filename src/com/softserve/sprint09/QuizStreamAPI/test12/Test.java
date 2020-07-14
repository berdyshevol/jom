package com.softserve.sprint09.QuizStreamAPI.test12;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * What will be the result of the following code?
 *
 *
 * Select one or more:
 * a. 14
 * b. 150
 * c. Compile Error
 * d. 140  <-- V
 * e. 15
 */
public class Test {
    public static void main(String[] args) {
        Stream.of(Stream.of(1, 2,3,4,5)
                .sorted(Comparator.reverseOrder())
                .limit(4)
                .reduce(0, (acc, x) -> acc + x), 0)
                .forEach(System.out::print);
    }
}

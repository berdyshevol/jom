package com.softserve.sprint09.QuizStreamAPI.test15;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * What will be the result of the following code?
 *
 *
 * Select one or more:
 * a. 3, 6, 9, 12
 * b. Compile Error
 * c. 0, 3, 6, 9  <-- V
 * d. 12, 9, 6, 3
 * e. 9, 6, 3, 0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(
                Stream.iterate(0, x-> x + 3)
                .limit(4)
                .map(x -> String.valueOf(x))
                .collect(Collectors.joining(", "))
        );
    }
}

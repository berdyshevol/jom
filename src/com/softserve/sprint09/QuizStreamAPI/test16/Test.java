package com.softserve.sprint09.QuizStreamAPI.test16;

import java.util.stream.Stream;

/**
 * What will be the result of the following code?
 *
 *
 * Select one or more:
 * a. 6321
 * b. 3216  <-- V
 * c. 0321
 * d. 3210
 * e. Compile Error
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(
                Stream.of(3,2,1)
                .peek(x -> System.out.print(x))
                .reduce((a, b) -> a+b)
                .orElse(0)
        );
    }
}

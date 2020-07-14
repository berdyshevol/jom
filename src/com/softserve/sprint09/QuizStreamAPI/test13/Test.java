package com.softserve.sprint09.QuizStreamAPI.test13;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * What will be the result of the following code?
 *
 *
 * Select one or more:
 * a. 211232
 * b. 122213  <-- V
 * c. 231221
 * d. 122321
 * e. Compile Error
 */
public class Test {
    public static void main(String[] args) {
        Stream.of(1, 12,2,3,2,21)
                .filter(x -> x>1)
                .map(x -> String.valueOf(x))
                .collect(Collectors.toCollection(TreeSet::new))
                .forEach(System.out::print);
    }
}

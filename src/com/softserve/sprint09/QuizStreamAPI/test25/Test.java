package com.softserve.sprint09.QuizStreamAPI.test25;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * How to convert the String number = "123456789"; to Stream
 *
 *
 * Select one or more:
 * a. Stream<Integer> numbers = number.chars();
 * b. IntStream numbers = number.codePoints();         <-- V
 * c. IntStream numbers = number.chars();              <-- V
 * d. Stream<Character> numbers = number.chars();
 * e. Stream<Integer> numbers = number.chars().boxed(); <-- V
 */
public class Test {
    public static void main(String[] args) {
        String number = "123456789";

//        Stream<Integer> numbers1 = number.chars();
        IntStream numbers2 = number.codePoints();
        IntStream numbers3 = number.chars();
//        Stream<Character> numbers4 = number.chars();
        Stream<Integer> numbers5 = number.chars().boxed();

    }
}

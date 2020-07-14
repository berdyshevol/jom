package com.softserve.sprint09.QuizStreamAPI.test26;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * How to convert the elements a1, a2, a3 to Stream
 *
 *
 * Select one or more:
 * a. Stream<Object> numbers = Stream.of(a1, a2, a3);      <-- V
 * b. Stream<Object> numbers = Arrays.stream(a1, a2, a3);
 * c. Stream<Object> numbers = Stream.generate(a1, a2, a3);
 * d. Stream<Object> numbers = Stream.concat(a1, a2, a3);
 * e. Stream<Object> numbers = Stream.builder().add(a1).add(a2).add(a3).build(); <-- V
 */

public class Test {
    public static void main(String[] args) {
        int a1 = 1, a2 = 2, a3 = 3;

        Stream<Object> numbers1 = Stream.of(a1, a2, a3);
//        Stream<Object> numbers2 = Arrays.stream(a1, a2, a3);
//        Stream<Object> numbers3 = Stream.generate(a1, a2, a3);
//        Stream<Object> numbers4 = Stream.concat(a1, a2, a3);
        Stream<Object> numbers5 = Stream.builder().add(a1).add(a2).add(a3).build();
    }
}

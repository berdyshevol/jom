package com.softserve.sprint09.QuizStreamAPI.test23;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * How to convert the array String[] count = {"One", "Two", "Three"}; to Stream
 *
 *
 * Select one or more:
 * a. Stream<String> numbers = Arrays.stream(count); <-- V
 * b. Stream<String> numbers = Stream.of(count);     <-- V
 * c. Stream<String> numbers = Stream.concat(count)
 * d. Stream<String> numbers = count.stream();
 * e. Stream<String> numbers = ArrayStream.of(count);
 */
public class Test {
    public static void main(String[] args) {
        String[] count = {"One", "Two", "Three"};
        Stream<String> numbers1 = Arrays.stream(count);
        Stream<String> numbers2 = Stream.of(count);
//        Stream<String> numbers3 = Stream.concat(count);
//        Stream<String> numbers4 = count.stream();
//        Stream<String> numbers5 = ArrayStream.of(count);
    }
}

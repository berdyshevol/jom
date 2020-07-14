package com.softserve.sprint09.QuizStreamAPI.test7;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream.of(2, 3, 0, 1)
                .map(num -> IntStream.range(0, num))
                .forEach(
                        stream -> stream.forEach(System.out::print)
                );
    }
}

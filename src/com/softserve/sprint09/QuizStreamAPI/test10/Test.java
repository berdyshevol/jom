package com.softserve.sprint09.QuizStreamAPI.test10;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream.concat(
                DoubleStream.of(1).boxed(),
                IntStream.of(2).boxed()
        )
                .map(Object::getClass)
                .forEach(System.out::print);
    }
}

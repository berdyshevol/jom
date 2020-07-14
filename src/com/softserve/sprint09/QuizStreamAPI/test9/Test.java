package com.softserve.sprint09.QuizStreamAPI.test9;

import java.util.stream.DoubleStream;

/**
 * What will be the result of the following code?
 *
 * Select one or more:
 * a. Integer Double
 * b. Compile Error
 * c. Integer Integer
 * d. Double Integer
 * e. Double Double <-- V
 */
public class Test {
    public static void main(String[] args) {
        DoubleStream.of((int)0, 1)
                .boxed()
                .map(Object::getClass)
                .forEach(System.out::print);
    }
}

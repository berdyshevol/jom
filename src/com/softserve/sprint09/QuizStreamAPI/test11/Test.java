package com.softserve.sprint09.QuizStreamAPI.test11;

/**
 * What will be the result of the following code?
 *
 * Select one or more:
 * a. abcd
 * b. abbadabc
 * c. abbadababc
 * d. Compile Error
 * e. abdc
 */

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String[] array = {"ab","bad","ab","abc"};
        Arrays.stream(array)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::print);
    }
}

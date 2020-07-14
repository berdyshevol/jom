package com.softserve.sprint09.QuizStreamAPI.test24;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * How to convert full Map<String, Integer> someMap; to Stream
 *
 *
 * Select one or more:
 * a. Stream<Integer> valuesStream = someMap.values().stream();
 * b. Stream<Map.Entry<String, Integer>> entriesStream = someMap.stream();
 * c. Stream<String> keysStream = someMap.keySet().stream();
 * d. Stream<Map.Entry<String, Integer>> entriesStream = Stream.of(someMap);
 * e. Stream<Map.Entry<String, Integer>> entriesStream = someMap.entrySet().stream(); <-- V
 */
public class Test {
    public static void main(String[] args) {
        Map<String, Integer> someMap = new HashMap<>();

        Stream<Integer> valuesStream1 = someMap.values().stream(); // it stream, but it is not map of stream
//        Stream<Map.Entry<String, Integer>> entriesStream2 = someMap.stream();
        Stream<String> keysStream3 = someMap.keySet().stream(); // it stream, but it is not map of stream
//        Stream<Map.Entry<String, Integer>> entriesStream4 = Stream.of(someMap);
        Stream<Map.Entry<String, Integer>> entriesStream5 = someMap.entrySet().stream();
    }
}

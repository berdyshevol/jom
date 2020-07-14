package com.softserve.sprint09.QuizStreamAPI.test5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<String>> table = new ArrayList<>();

        table.add(Arrays.asList("1", "2", "3"));
        table.add(Arrays.asList("4", "5"));
        table.stream()
                .flatMap(Collection::stream)
                .skip(1)
                .forEach(System.out::print);
    }
}

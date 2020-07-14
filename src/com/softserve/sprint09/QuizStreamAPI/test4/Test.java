package com.softserve.sprint09.QuizStreamAPI.test4;

import com.softserve.sprint04.task5.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<String>> table = new ArrayList<>();
        table.add(Arrays.asList("1", "2", "3"));
        table.add(Arrays.asList("4", "5"));
        table.stream()
                .map(list -> list.stream())
                .skip(1)
                .forEach(
                        stream -> stream.forEach(System.out::print)
                );
    }
}

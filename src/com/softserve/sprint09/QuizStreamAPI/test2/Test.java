package com.softserve.sprint09.QuizStreamAPI.test2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int sum = Arrays.stream(new int[] {1, 2, 3, 4})
                .limit(3)
                .filter(x -> x > 2)
                .map(i -> i *2)
                .sum();
        System.out.println(sum);
    }
}
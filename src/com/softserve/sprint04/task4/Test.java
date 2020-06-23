package com.softserve.sprint04.task4;

public class Test {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[3];
        int intFromPosition = ArrayUtil.<Integer>setAndReturn(numbers, 52, 1);
        System.out.println(intFromPosition);

        String[] words = new String[3];
        String wordFromPosition = ArrayUtil.setAndReturn(words, "Oleg", 2);
        System.out.println(wordFromPosition);
    }
}

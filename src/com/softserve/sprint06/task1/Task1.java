package com.softserve.sprint06.task1;

import java.util.Arrays;
import java.util.function.Predicate;
/*public*/ class MyUtils {
    public static int getCount(int[] array, Predicate<Integer> predicate) {
        int count = 0;
        for (int item : array) {
            if (predicate.test(Integer.valueOf(item))) {
                count++;
            }
        }
        return count;
    }
}

/**
 * Implement a static method getCount(...) that takes an array of integers as the first parameter.
 * The second parameter is a functional interface that works with integers and defines a some condition.
 *
 * The method should return the count of elements in the array that satisfy the condition defined by the second argument.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] array = {0,2,4,6,8,10,12,14};

        Predicate<Integer> moreThanTen = item -> item > 10;
        System.out.println(MyUtils.getCount(array, moreThanTen));

        System.out.println(MyUtils.getCount(array, item -> item >=5 && item <= 10));
    }
}

package com.softserve.sprint04.task4;

public class ArrayUtil {
    public static <T> T setAndReturn(T[] array, T item, int position) {
        array[position] = item;
        return item;
    }
}

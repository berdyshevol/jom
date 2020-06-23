package com.softserve.sprint04.task5;

public class ArrayUtil {
    public static <T extends Number> double averageValue(Array<T> array) {
        double result = 0.0;
        for (int i = 0; i < array.length(); i++) {
            result += array.get(i).doubleValue();
        }
        return result / array.length();
    }
}

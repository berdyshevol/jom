package com.softserve.sprint06.task2;

import java.util.Arrays;
import java.util.function.Consumer;
/*public*/ class App {
    static Consumer<double[]> cons = array -> {
        for (int i = 0; i < (array).length; i++) {
            if (array[i] > 2) (array)[i] *= 0.8;
            else (array)[i] *= 0.9;
        }
    };
    public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {
        double [] result = Arrays.copyOf(initialArray, initialArray.length);
        consumer.accept(result);
        return result;
    }
}

/**
 * Create the static field cons of type Consumer and assign it the lambda expression
 * that takes an array of doubles as a parameter and changes it using the next rule:
 * all values that are greater than 2 should be multiplied by 0.8, and other values should be multiplied by 0.9.
 *
 * Also implement a static method getChanged(...) that takes an array of doubles as a first parameter
 * and Consumer implementation as a second. The method should return an array changed by the second parameter.
 *
 * The getChanged(...) method should not change initial array.
 */
public class Task2 {
    public static void main(String[] args) {
        double[] array = {0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0};
        App.cons.accept(array);
        App.getChanged(array, arr -> Arrays.stream((double [])arr).forEach(System.out::println));
//        Arrays.stream(array).forEach(System.out::println);

    }
}

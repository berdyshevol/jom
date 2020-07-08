package com.softserve.sprint06.test6;

import java.util.Arrays;

import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;

class MyUtils{
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        // TODO: попробовать по современному
//        Integer max = numbers.get(0);
//        for (Integer number : numbers) {
//            if (pr.test(number) && number > max) max = number;
//        }
//        return max;
        return numbers.stream().max( (x, y) -> {
                if (pr.test(x) && pr.test(y))
                    return x.compareTo(y);
                return 0;
            }
        ).get();
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> getFilterd, Predicate<Integer> predicate){
        return getFilterd.apply(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {
        return getFilterdValue(
                MyUtils::findMaxByCondition,
                predicate
        );
    }
}

/**
 * Implement a static method findMaxByCondition(...) of MyUtils class that takes
 * List of integers as a first parameter
 * and predicate as a second
 * and returns the max value from the list that satisfies the condition of the predicate.
 *
 * Also, implement getFilterdValue(...) method of User class.
 * The getFilteredValue(...) method should be able to take MyUtils.findMaxByCondition(...) as a first parameter
 * and Predicate as a second.
 * This method should return an integer value, evaluated from User's field values using the first
 * and second parameters of getFilterdValue(...) method.
 *
 * One more method that needs to be implemented in User class is getMaxValueByCondition(...).
 * This method has one Predicate parameter. The implementation should call getFilterdValue(...)
 * method with MyUtils.findMaxByCondition(...) as a first parameter and passed along Predicate as a second.
 */

public class Test6 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        System.out.println(
                MyUtils.findMaxByCondition(
                        list,
                        x -> x > 5
                )
        );
    }
}

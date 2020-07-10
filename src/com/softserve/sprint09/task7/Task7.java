package com.softserve.sprint09.task7;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*public*/ class MyUtils {
    public Stream<Integer> duplicateElements(Stream<Integer> stream) {
        return stream
                .filter(x -> x != null)
                .collect(Collectors.groupingBy(
                    Integer::intValue,
                    Collectors.counting()
               )).entrySet().stream()
                 .filter(entrySet -> entrySet.getValue() == null ||entrySet.getValue() > 1)
                 .map(entrySet -> entrySet.getKey())
                 .sorted();
    }
}

/**
 * Create a Stream<Integer> duplicateElements(Stream<Integer> stream) method of the MyUtils class
 * to return a sorted stream of duplicated elements of the input stream.
 * For example, for a given elements
 * [3, 2, 1, 1, 12, 3, 8, 2, 4, 2]
 * you should get
 * [1, 2, 3]
 */
public class Task7 {
    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 1, 12, 3, 8, 2, 4, 2, -1, -1};
        new MyUtils().duplicateElements(Arrays.stream(arr).boxed()).forEach(System.out::println);
//        Integer i10 = new Integer(10);
//        Integer j10 = new Integer(10);
//        System.out.println(i10.equals(j10));
    }
}

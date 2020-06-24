package com.softserve.sprint04.quize_collection.test4;

import java.util.Arrays;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        List<Integer> list = Arrays.asList(arr);
        list.add(0, 5); // runtime: UnsupportedOperationException
        System.out.println(list);
    }
}

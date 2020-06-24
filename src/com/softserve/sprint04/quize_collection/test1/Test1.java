package com.softserve.sprint04.quize_collection.test1;

import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        List<Integer> list = Arrays.asList(arr);
        arr[0] = 5;
        System.out.println(list); // [5, 2, 3, 4]
    }
}

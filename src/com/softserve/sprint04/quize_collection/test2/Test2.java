package com.softserve.sprint04.quize_collection.test2;

import java.util.Arrays;
import java.util.List;


public class Test2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
//        List<Integer> list = Arrays.asList(arr); // java: incompatible types: inference variable T has incompatible bounds
        arr[0] = 5;
//        System.out.println(list);
    }
}
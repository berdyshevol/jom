package com.softserve.sprint04.quize_collection.test6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        List<Integer> temp = Arrays.asList(arr);
        List<Integer> list = new ArrayList<>(temp);
        list.add(0, 5);
        System.out.println(list); // -> [5, 1, 2, 3, 4]
    }
}

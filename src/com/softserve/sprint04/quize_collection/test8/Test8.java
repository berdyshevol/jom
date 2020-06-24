package com.softserve.sprint04.quize_collection.test8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test8 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        List<Integer> temp = Arrays.asList(arr);
        List<Integer> list = new ArrayList<>();
        list.addAll(temp);
        list.add(0, 5);
        System.out.println(list); // -> [5, 1, 2, 3, 4]
    }
}

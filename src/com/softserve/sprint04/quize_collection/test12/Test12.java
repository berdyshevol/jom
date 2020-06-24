package com.softserve.sprint04.quize_collection.test12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test12 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Object[] arr = list.toArray();
        list.add(0, 5);
        System.out.println(Arrays.toString(arr)); // -> [1, 2, 3, 4]
    }
}

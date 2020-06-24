package com.softserve.sprint04.quize_collection.test5;

//package com.softserve.sprint04.quize_collection.test4;

import java.util.Arrays;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        List<Integer> list = Arrays.asList(arr);
        list.clear(); // runtime: UnsupportedOperationException
        System.out.println(list);
    }
}

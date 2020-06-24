package com.softserve.sprint04.quize_collection.test22;

import java.util.ArrayList;
import java.util.List;

public class Test22 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i).contains("3")) { // runtime error: IndexOutOfBoundsException
                list.remove(i);
            }
        }
        System.out.println(list); // -> [1, 2, 3]
    }
}

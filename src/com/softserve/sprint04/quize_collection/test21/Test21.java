package com.softserve.sprint04.quize_collection.test21;

import java.util.ArrayList;
import java.util.List;

public class Test21 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("3")) {
                list.remove(i);
            }
        }
        System.out.println(list); // -> [1, 2, 3]
    }
}

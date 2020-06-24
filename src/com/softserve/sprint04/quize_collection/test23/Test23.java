package com.softserve.sprint04.quize_collection.test23;

import java.util.ArrayList;
import java.util.List;

public class Test23 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        for (String cur: list) {
            if (cur.contains("3")) {
                list.remove(cur);
            }
        }
        System.out.println(list); //
    }
}

package com.softserve.sprint04.quize_collection.test24;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test24 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String cur = iterator.next();
            if (cur.contains("3")) {
                iterator.remove();
            }
        }
        System.out.println(list); // -> [1, 2]
    }
}

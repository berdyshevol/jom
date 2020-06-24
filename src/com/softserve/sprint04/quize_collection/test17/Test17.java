package com.softserve.sprint04.quize_collection.test17;

import java.util.HashSet;
import java.util.Set;

public class Test17 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(null);
        set.add(null);
        set.add(null);
        System.out.println(set); // -> [null]
    }
}

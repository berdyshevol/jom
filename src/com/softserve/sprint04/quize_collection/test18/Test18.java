package com.softserve.sprint04.quize_collection.test18;

import java.util.Set;
import java.util.TreeSet;

public class Test18 {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(null);
        System.out.println(set); // runtime error: NullPointerException
    }
}

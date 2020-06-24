package com.softserve.sprint04.quize_generics.test3;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {

        // What will be the output of the following program?
        List<Integer> num = new ArrayList<>();
//        num.add("763"); // Compile error
        System.out.println(num.get(0));
    }
}

package com.softserve.sprint04.quize_generics.Test10;

public class Test10 {
    public static void main(String[] args) {
        String hundred = "100";

        Integer i1 = Integer.valueOf(hundred);
        Integer i2 = Integer.parseInt(hundred);
        Integer i3 = new Integer(hundred);
        Integer i4 = 100;
        Integer i5 = 100;

        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(i4 == i5);
    }
}

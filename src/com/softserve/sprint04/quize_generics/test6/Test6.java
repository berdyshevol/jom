package com.softserve.sprint04.quize_generics.test6;

class Wrapper<T extends Number> {
    private T value;

    public Wrapper(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class Test6 {
    public static void main(String[] args) {
        Wrapper<? extends Number> num = new Wrapper<Integer>(123);
        System.out.println(num.getValue()); // 123 - works no problem
    }
}

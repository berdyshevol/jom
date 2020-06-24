package com.softserve.sprint04.quize_generics.Test4;

class Wrapper<T extends Number> {
    private T value;
    public Wrapper(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class Test4 {
    public static void main(String[] args) {

        // What is the result of executing the following program:

        Wrapper<? extends Number> number = new Wrapper<>(111L);
//        Wrapper<? extends Double> doubleNum = new Wrapper<>(33.3f); // Cannot infer arguments
//        Wrapper<Integer> intNum = new Wrapper<>(222L); // Cannot infer arguments
        System.out.println(number.getValue());
    }
}

package com.softserve.sprint05.quiz.test8;

public class Test8 {
    public static void main(String[] args) {
        System.out.println("1");
        try {
            System.out.println("2");
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("3");
            throw new RuntimeException("first");
        } catch (RuntimeException e) {
            System.out.println("4");
            throw new RuntimeException("second");
        } finally {
            System.out.println("5");
            throw new RuntimeException("third"); // -> this will throw
        }
    }
}

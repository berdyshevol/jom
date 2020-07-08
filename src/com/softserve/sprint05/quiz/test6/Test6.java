package com.softserve.sprint05.quiz.test6;

public class Test6 {

//    What will be the result of the execution of the code below:
    public static void m1() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        try {
            m1();
            System.out.println("I");
        } finally {
            System.out.println("T"); // -> T
        }
        System.out.println("Academy");
    }
}

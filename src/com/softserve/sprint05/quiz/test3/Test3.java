package com.softserve.sprint05.quiz.test3;

class FirstException extends Exception {}
class SecondException extends Exception {}

public class Test3 {

    public static void do1() throws FirstException {
        throw new FirstException();
    }

    public static void do2() throws SecondException {
        throw new SecondException();
    }

    public static void main(String[] args) throws Exception {
        // What is the result of the following code?
        // SecondException will be thrown as a result of excecution
        try {
            do1();
        } finally {
            do2();
        }
    }
}

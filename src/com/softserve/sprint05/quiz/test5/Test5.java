package com.softserve.sprint05.quiz.test5;

public class Test5 extends Exception {
    int data = 5;
    public Test5(){}
    public Test5(String str) {
        super(str);
    }

    private void method() { // no throws MyExeption
        if (data > 5) {
//            throw new Test5("Message"); // compile error
        }
        else {
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        Test5 obj = new Test5();
        obj.method();
    }
}

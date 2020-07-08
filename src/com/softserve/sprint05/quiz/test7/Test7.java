package com.softserve.sprint05.quiz.test7;

// What will happen when you compile and run the following code?
// -> Method 1 ends
class TestClass {
    public static void main(String[] args) {
        try {
            AnotherClass obj = new AnotherClass();
            obj.method1();
            System.out.println("Main ends");
        } catch (Exception e) {
        }
    }

}

class AnotherClass {
    public void method2() {
        throw new ArrayIndexOutOfBoundsException();
    }
    public void method1() {
        try {
            method2();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } finally {
            System.out.println("Method 1 ends");
        }
    }
}
public class Test7 {

}

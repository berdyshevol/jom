package com.softserve.sprint05.quiz.test4;

public class Test4 {
    public static void main(String[] args) {
        int i = 0;
        try {
            int k = 5 / i;
        }
        catch (RuntimeException e) {
            System.out.println("RuntimeException");
        }
//        catch (ArithmeticException e) { // compile error (above Parent now Child)
//            System.out.println("ArithmeticException");
//        }
        catch (Exception e) {
            System.out.println("Exception");
        }
        finally {
            System.out.println("I am here");
        }
        System.out.println("I do believe");
    }
}

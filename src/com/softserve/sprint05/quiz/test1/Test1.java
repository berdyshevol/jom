package com.softserve.sprint05.quiz.test1;

// result is:
// ArithmeticException
// I am here
// I do believe
public class Test1 {
    public static void main(String[] args) {
        int i = 0;
        try {
            int k = 5 / i;
        }
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        }
        catch (RuntimeException e) {
            System.out.println("RuntimeException");
        }
        catch (Exception e) {
            System.out.println("Exception");
        }
        finally {
            System.out.println("I am here");
        }
        System.out.println("I do believe");
    }
}

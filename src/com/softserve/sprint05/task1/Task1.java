package com.softserve.sprint05.task1;

/**
 * Create a method for calculating an area of a rectangle
 * int squareRectangle(int a, int b), which should throw an IllegalArgumentException if at least one of its arguments is non positive.
 *
 * Create trySquareRectangle method which takes two parameters and calls squareRectangle to evaluate an area of a rectangle.
 * Catch exceptions that can be generated.
 * trySquareRectangle shouldn't generate any exceptions.
 * In case when one or two parameters are negative the method should return -1;
 */

class Operation {
    public static int squareRectangle(int a, int b) throws IllegalArgumentException {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("both arguments should be more than zero");
        }
        return a * b;
    }
    public static int trySquareRectangle(int a, int b) {
        try {
            return squareRectangle(a, b);
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        System.out.println(Operation.trySquareRectangle(1, 87));
        System.out.println(Operation.trySquareRectangle(-1, 87));
        System.out.println(Operation.squareRectangle(2, 3));
        System.out.println(Operation.squareRectangle(-2, 3));
    }
}

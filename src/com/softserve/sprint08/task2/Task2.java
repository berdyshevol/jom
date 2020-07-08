package com.softserve.sprint08.task2;

import java.util.function.BinaryOperator;

class Accountant {
    public static int sum(int x, int y) {
        ParallelCalculator calculator = new ParallelCalculator(Integer::sum, x, y);
        Thread t = new Thread(calculator);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
        }
        return calculator.result;
    }
}

/**
 * Suppose, you have class from task #1 ParallelCalculator that is able to execute an operation in separate thread.
 * It uses an implementation of Runnable interface for this.
 *
 * You need to create Accountant class with a static sum(...) method
 * that takes two parameters of type int and returns their sum.
 * Use ParallelCalculator for this.
 * The sum(...) method doesn't throw any checked exceptions.
 *
 * The sum must be evaluated in a separate thread
 * (please, do not call run() method of ParallelCalculator. Use start() method on object of type Thread).
 *
 * Using Thread.sleep() method is unwelcomed in this task.
 */

class ParallelCalculator implements Runnable {
    public int result;
    private BinaryOperator<Integer> binaryOperator;
    private int operator1;
    private int operator2;

    public ParallelCalculator(BinaryOperator<Integer> binaryOperator, int operator1, int operator2) {
        this.binaryOperator = binaryOperator;
        this.operator1 = operator1;
        this.operator2 = operator2;
    }

    @Override
    public void run() {
        this.result = binaryOperator.apply(operator1, operator2);
    }
}

public class Task2 {
    public static void main(String[] args) {
        System.out.println(Accountant.sum(1,2));
    }
}

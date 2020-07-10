package com.softserve.sprint08.task1;

import java.util.function.BinaryOperator;

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

/**
 * Create ParallelCalculator class that will be able to execute an operation in parallel thread.
 *
 * Use the implementation of Runnable interface for this.
 *
 * Constructor of ParallelCalculator should take 3 parameters:
 *
 * The BinaryOperator<Integer> to define an operation that will be executed,
 * The operand1 of type int and operand2 of type int.
 * The ParallelCalculator class should have not  private result field of type int
 * where the result of the operation will be written when it's executed.
 */
public class Task1 {
}

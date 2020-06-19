package com.softserve.sprint03;

interface Strategy {
    double doOperation(int a, int b);
}

public class Task3 {
    public static void execute(int a, int b, Strategy strategy) {
        double result = strategy.doOperation(a, b);
        System.out.println(result);
    }

    public static void addAtoB(int a, int b) {
        execute(a, b, new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a + b;
            }
        });
    }

    public static void subtractBfromA(int a, int b) {
        execute(a, b, new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a - b;
            }
        });
    }

    public static void multiplyAbyB(int a, int b) {
        execute(a, b, new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a * b;
            }
        });
    }

    public static void divideAbyB(int a, int b) {
        execute(a, b, new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a / b;
            }
        });
    }

    public static void main(String[] args) {
        addAtoB(1, 2);
    }
}

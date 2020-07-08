package com.softserve.sprint08.quiz.test6;

/**
 * What will be the output of the following Java code?
 * Select one:
 * None of these.
 * Compilation fails.
 * It prints "Thread one. Thread two.".
 * The output cannot be determined.
 * An exception occurs at runtime. <-- correct
 */
public class Test6 extends Thread {
    public static void main(String[] args) {
        Test6 t = new Test6();
        t.start();
        System.out.println("one ");
        t.start(); // <--- cannot restart thread
        System.out.println("two ");
    }
    public void run() {
        System.out.println("Thread ");
    }
}

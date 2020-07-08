package com.softserve.sprint08.quiz.test5;

/**
 * What is the output of the below Java code?
 * Select one:
 * Compilation Error.
 * None of these.
 *  It will print “Hello Java” …. 20 times for obj1 and obj2.  <-- correct
 * DeadLock.
 */
public class Test5 implements Runnable {
    String x, y;
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                x = "Hello";
                y = "Java";
                System.out.print(x+" " + y + " ");
            }
        }
    }

    public static void main(String[] args) {
        Test5 run = new Test5();
        Thread obj1 = new Thread(run);
        Thread obj2 = new Thread(run);
        obj1.start();
        obj2.start();
    }
}

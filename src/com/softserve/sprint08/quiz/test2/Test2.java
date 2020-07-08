package com.softserve.sprint08.quiz.test2;

class ThreadDemo implements Runnable {
    int x = 0, y = 0;
    int addX() {x++; return x;}
    int addY() {y++; return y;}
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println(Thread.currentThread().getName() + ": " + addX() + " " + addY());
    }
}

/**
 * What is the order of the output of the following java code fragment?
 * Will print in this order: 1 1 2 2 3 3 4 4 5 5...
 * Compile time Error: There is no start() method.
 * Will print in this order: 1 2 3 4 5 6... 1 2 3 4 5 6...
 * Will print but may or may not be in an order for Thread t1 and t2 (e.g: 1 1 2 2 1 1 3 3... up to 10 10) <- correct
 * None of these.
 *
 */
public class Test2 {
    public static void main(String[] args) {
        ThreadDemo obj1 = new ThreadDemo();
        ThreadDemo obj2 = new ThreadDemo();
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        t2.start();
    }
}

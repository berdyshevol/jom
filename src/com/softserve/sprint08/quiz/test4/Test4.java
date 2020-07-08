package com.softserve.sprint08.quiz.test4;

class MyRunnable implements Runnable {
    public void run() {
        // ...
    }
}

/**
 * Which of the following piece of code will create and start this thread?
 * Select one:
 * new MyRunnable().start();
 * None of these.
 * new Runnable(MyRunnable).start();
 * new Thread(new MyRunnable()).start(); <- correct
 * new Thread(MyRunnable).run();
 */

public class Test4 {
    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
    }
}

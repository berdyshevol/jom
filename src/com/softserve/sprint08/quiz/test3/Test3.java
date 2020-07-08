package com.softserve.sprint08.quiz.test3;

/**
 * What will be the output of the java program below?
 *  Select one:
 * 1 2 3
 * 1 3
 * None of these
 * 1 2 <-- correct
 *  It fails to compile because the IllegalMonitorStateException of wait() is not dealt with in line 11.
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println("1 ");
        synchronized (args) {
            System.out.println("2 ");
            try {
                args.wait();
            }
            catch (InterruptedException e) {}
        }
        System.out.println("3 ");
    }
}

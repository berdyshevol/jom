package com.softserve.sprint08.task3;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

class Interactor {

    int x;

    synchronized public void serve(UnaryOperator<Integer> uo, int initializer) throws InterruptedException{
        System.out.println("Serving thread running");
        System.out.println("Serving thread initializes the key");
        this.x = uo.apply(initializer);
        printf("key = %d", this.x);
        notifyAll();
        wait();
        System.out.println("Serving thread resumed");
    }

    synchronized public void consume(BinaryOperator<Integer> bo, int operand2) throws InterruptedException{
        wait(3000);
        printf("Consuming thread received the key. key = %d", this.x);
        this.x = bo.apply(this.x, operand2);
        printf("Consuming thread changed the key. key = %d", this.x);
        notifyAll();
    }

    synchronized private void printf(String format, int d) {
        System.out.println(String.format(
                format,
                d
        ));
    }
}

class threadExample1 {
    public static void threadRun() {
        Interactor interactor = new Interactor();
        Thread t1 = new Thread(() -> {
            try {
                interactor.serve(x -> -x+4, 11);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                interactor.consume((a, b) -> a+2*b, 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            t2.start();
            t1.start();
            t2.join();
            t1.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class threadExample2 {
    public static void threadRun() {
        Interactor interactor = new Interactor();
        Thread t1 = new Thread(() -> {
            try {
                interactor.serve(x -> -x, 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                interactor.consume((a, b) -> a+b, 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            t2.start();
            t1.start();
            t2.join();
            t1.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * You need to implement the methods of the Interactor class so that output will look like this:
 * - Serving thread running
 * - Serving thread initializes the key
 * - key = -7
 * - Consuming thread received the key. key = -7
 * - Consuming thread changed the key. key = 33
 * - Serving thread resumed
 *
 * The serve(...) method should initialize the x field with applied its first parameter to the second one
 * and print the messages only about its own actions.
 *
 * The counsume(...) method should wait until serve initializes x field
 * and then change x by assigning it the result of applying the method's first parameter to the second
 * and the third ones. This method also prints the messages only about its own actions.
 *
 * Assume that the consume(...) method should be able to execute without the serve(...) method after waiting for 3 seconds.
 *
 * Use synchronized blocks (or methods), wait() and notify() methods for the implementation.
 */
public class Task3 {
    public static void main(String[] args) {
        threadExample2.threadRun();
    }
}

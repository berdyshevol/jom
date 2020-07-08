package com.softserve.sprint08.playground;

class FunnyThread {

    int x;

    synchronized public void one() throws InterruptedException{
        System.out.println("1");
        notify();
        wait();
        System.out.println("3");
        notify();
        wait();
        System.out.println("5");
        notify();
        wait();
    }

    synchronized public void two() throws InterruptedException{
        wait();
        System.out.println("2");
        notify();
        wait();
        System.out.println("4");
        notify();
        wait();
        System.out.println("6");
        notify();
    }
}

class threadExample {
    public static void threadRun() {
        FunnyThread funnyThread = new FunnyThread();
        Thread t1 = new Thread(() -> {
            try {
                funnyThread.one();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                funnyThread.two();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            t2.start();
            t1.start();
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test1{
    public static void main(String[] args) {
        threadExample.threadRun();
    }
}

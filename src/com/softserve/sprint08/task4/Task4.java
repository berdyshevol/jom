package com.softserve.sprint08.task4;

/**
 * Fix the problem with the preloaded implementation of the class MyThread.
 *
 * Test starts both threads with the code:
 *
 *         MyThreads.t1.start();
 *         MyThreads.t2.start();
 *
 * The goal of each thread is to update m and n fields and not switch between threads while loop is executed.
 *
 * You need to get an output like this:
 *
 * Thread1 n = 0
 * Thread1 n = 1
 * Thread1 n = 2
 * Thread1 n = 3
 * Thread1 n = 4
 * Thread2 m = 0
 * Thread2 m = 1
 * Thread2 m = 2
 * Thread2 m = 3
 * Thread2 m = 4
 * Thread2 n = 5
 * Thread2 n = 6
 * Thread2 n = 7
 * Thread2 n = 8
 * Thread2 n = 9
 * Thread2 success!
 * Thread1 m = 5
 * Thread1 m = 6
 * Thread1 m = 7
 * Thread1 m = 8
 * Thread1 m = 9
 * Thread1 success!
 * Please, don't change actions that change variables or print output within run() methods. Use only thread synchronization assets.
 */
//
//class MyThreads {
//    public final static Object den = new Object();
//    public final static Object ada = new Object();
//
//    public static int n;
//    public static int m;
//
//    public static Thread t1 = new Thread() {
//        public void run() {
//            synchronized (den) {
//                System.out.println("t1 den");
////                for(int i = 0; i < 5; i++, n++)
////                    System.out.println("Thread1 n = " + n);
////                Thread.yield();
//                den.notify();
//            }
//                synchronized (ada) {
////                    for(int i = 0; i < 5; i++, m++)
////                        System.out.println("Thread1 m = " + m);
////                    System.out.println( "Thread1 success!");
//                    System.out.println("t1 ada");
//                }
////            }
//        }
//    };
//
//    public static Thread t2 = new Thread() {
//        public void run() {
//            synchronized (ada) {
////                for(int i = 0; i < 5; i++, m++)
////                    System.out.println("Thread2 m = " + m);
////                Thread.yield();
//                System.out.println("t2 ada");
//                synchronized (den) {
////                    for(int i = 0; i < 5; i++, n++)
////                        System.out.println("Thread2 n = " + n);
////                    System.out.println("Thread2 success!");
//                    System.out.println("t2 den");
//                }
//            }
//        }
//    };
//}

class MyThreads {
    public final static Object den = new Object();
    public final static Object ada = new Object();

    public static int n;
    public static int m;

    public static Thread t1 = new Thread() {
        public void run() {
            synchronized (den) {
                for (int i = 0; i < 5; i++, n++)
                    System.out.println("Thread1 n = " + n);
            }

            synchronized (ada) {
                ada.notify();
                try { ada.wait(200); } catch (Exception e) {}
                for(int i = 0; i < 5; i++, m++)
                    System.out.println("Thread1 m = " + m);
                System.out.println( "Thread1 success!");
            }
        }
    };

    public static Thread t2 = new Thread() {
        public void run() {
            synchronized (ada) {
                try {ada.wait(200);} catch (Exception e) {}
                for (int i = 0; i < 5; i++, m++)
                    System.out.println("Thread2 m = " + m);

                synchronized (den) {
                    for(int i = 0; i < 5; i++, n++)
                        System.out.println("Thread2 n = " + n);
                    System.out.println("Thread2 success!");
                    ada.notify();
                }
            }
        }
    };
}

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        MyThreads.t1.start();
        MyThreads.t2.start();
//        MyThreads.t1.join();
//        MyThreads.t2.join();
    }
}

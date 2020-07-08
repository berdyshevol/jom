package com.softserve.sprint05.quiz.test9;

class ParentTest {
    public void test() throws Exception {
        System.out.println("From Parent test");
    }
}

class ChildTest extends ParentTest {
    public void test() {
        System.out.println("From Child test");
    }

    public static void mainChildTest() {
        ParentTest obj = new ChildTest();
//        obj.test(); // compile error: surround try/catch or throws Exception in method signature
    }
}

public class Test9  {
    public static void main(String[] args)  {
        new ChildTest().mainChildTest();
    }
}

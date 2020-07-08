package com.softserve.sprint05.quiz.test2;

class Test {
    private String str = "a";
    void a() {
        try {
            str += "b";
            b();
        } catch (Exception e) {
            str += "c";
        }
    }
    void b() throws Exception {
        try {
            str += "d";
            c();
        } catch (Exception e) {
            throw  new Exception(); // why this exception is not thrown but goes to finally
        } finally {
            str += "e";
        }
        str += "f";
    }
    void c() throws Exception {
        throw new Exception();
    }
    void display() {
        System.out.println(str);
    }
}

public class Test2 {
    public static void main(String[] args) {
        Test obj = new Test();
        obj.a();
        obj.display(); // -> abdec
    }
}

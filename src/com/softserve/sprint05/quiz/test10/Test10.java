package com.softserve.sprint05.quiz.test10;

class Perent {
    protected void m() throws Exception {

    }
}

class Child extends Perent {
    @Override
    public void m() {}
}

public class Test10 {
    public static void main(String[] args) {
        Perent a = new Child(); // a.m() - m from Perent
        ((Child)a).m(); // Почему здесь не нужен try/catch потому что работает m() from Child
//        a.m();
    }
}

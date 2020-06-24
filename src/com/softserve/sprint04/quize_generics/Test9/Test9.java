package com.softserve.sprint04.quize_generics.Test9;

class A {}
class B extends A {}
class App<T> {}

public class Test9 {
    public static void main(String[] args) {

        // Choose the right one to compile the following code:

        App<B> b = new App<>();
        App <? extends A> a = b;
//        App <A> a = b;
//        App <? super A> aa = bb;
//        App <B extends A> a = b;
//        App <B super A> a = b;
//        App <T super A> a = b;
//        App <B extends A> a = b;
    }
}

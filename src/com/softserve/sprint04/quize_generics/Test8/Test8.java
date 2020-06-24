package com.softserve.sprint04.quize_generics.Test8;

class A {}
class B extends A {}
class C extends B {}
public class Test8 {
    static class App<T> {}
    public static void method(App<? super B> value) {}
    public static void main(String[] args) {

//        What will be the output of the following program?

        method(new App<A>());
        method(new App<B>());
//        method(new App<C>()); // cannot be converted to
        method(new App());
    }
}

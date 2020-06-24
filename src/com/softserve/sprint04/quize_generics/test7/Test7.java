package com.softserve.sprint04.quize_generics.test7;

// Which of following class definitions will be compile without errors?

// 1
//class D<T> {
//    T[] values;
//    public D() {
//        values = new T[5]; // generic array creation
//    }
//}

//  // 2
//class C<T> {
//    T[] values;
//    public C() {
//        values = new T(); // unexpected type, required class, found type parameter T
//    }
//}
//
// // 3
//class A<T> {
//    static T values; // java: non-static type variable T cannot be referenced from a static context
//}

// 4 - it works
class B<T> {
    T values;
    public B(T v) {
        this.values = v;
    }
}

public class Test7 {
    public static void main(String[] args) {

    }
}

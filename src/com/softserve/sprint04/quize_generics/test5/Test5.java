package com.softserve.sprint04.quize_generics.test5;

// What will be the output of the following program?

public class Test5 {

//    static class Mapper {
//        public static T map(T t) { // cannot find symbol class T
//            return t;
//        }
//    }

    static class Mapper {
        public static<T> T map(T t) {
            return t;
        }
    }

    public static void main(String[] args) {
        String str = Mapper.<String>map("abc");
        System.out.println(str);
    }
}

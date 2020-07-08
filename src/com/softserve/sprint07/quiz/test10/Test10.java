package com.softserve.sprint07.quiz.test10;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Anno{
    int value() default 15;
}
public class Test10 {
    @Anno(10)
    public static void tеst(int i) { }
    public static void main(String [] args) {
//        Method m = new Test10().getClass().getMethod("test"); // compile error
//        Anno anno = m.getAnnotation(Anno.class);
//        System.out.println(anno.value());
    }
}

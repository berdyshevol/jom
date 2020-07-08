package com.softserve.sprint07.task2;

import java.lang.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Review {
    String reviewer();
    String date() default "today";
}

@Deprecated
class Util {
    public static void review(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(Review.class)) {
                String date = clazz.getDeclaredAnnotation(Review.class).date().equals("today")
                        ? new SimpleDateFormat("yyyy-MM-dd").format(new Date())
                        : clazz.getDeclaredAnnotation(Review.class).date();
                System.out.println(String.format(
                        "Class %s was reviewed %s by %s.",
                        className,
                        date,
                        clazz.getDeclaredAnnotation(Review.class).reviewer()
                ));
            }
            else {
                System.out.println(String.format("Class %s isn't marked as Reviewed", className));
            }
        } catch (ClassNotFoundException e) {
            System.out.println(String.format("Class %s was not found", className));
        }
    }
}

/**
 * Create annotation Review with two string elements: reviewer and date.
 * Element date has default string value today.
 * This annotation can be applied to class when we execute static method review(String className) of class Util
 * and the result of this method will be printed Class <ClassName> was reviewed <date in format yyyy-mm-dd> by <reviewe>
 *     to standard output (console).
 * If the class <className> isn’t annotated we show message: Class <ClassName> isn't marked as Reviewed.
 * If the class was not found we show message: Class <ClassName> was not found.
 */

@Review(reviewer = "me")
class Test1 {}

class Test2 {}

public class Task2 {
    public static void main(String[] args) {
        Util.review("com.softserve.spring07.task2.Test1");
        Util.review("com.softserve.spring07.task2.Test2");
        Util.review("com.softserve.spring07.task2.Test3");
    }
}

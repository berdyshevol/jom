package com.softserve.sprint07.task3;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TestSuite {
    String[] value();
}

@SuppressWarnings({"unchecked", "deprecated"})
class TestSuitHandler {
    public static void run(Class<?> clazz) {
        String[] methodNames = getTestSuitAnnotationValues(clazz);
        if (methodNames == null) {
            printNoAnnotated(clazz);
        } else {
            for (String methodName : methodNames) {
                Method method = getMethodAndNoArgs(clazz, methodName);
                if (method == null) continue;
                tryInvoke(clazz, methodName, method);
            }
        }
    }

    private static void printNoAnnotated(Class<?> clazz) {
        System.out.println(String.format(
                "Class %s isn't annotated",
                clazz.getSimpleName()
        ));
    }

    private static void tryInvoke(Class<?> clazz, String methodName, Method method) {
        try {
            printf(clazz.getSimpleName(),methodName, "started");
            method.invoke(clazz.getDeclaredConstructor().newInstance());
            printf(clazz.getSimpleName(),methodName, "finished");
        } catch (IllegalAccessException | InvocationTargetException
                | InstantiationException | NoSuchMethodException e) {
            return;
        }
    }
    private static void printf(String ...args) {
        System.out.println(String.format(
                "\\t -- Method %s.%s %s --",
                args[0],
                args[1],
                args[2]
        ));
    }

    private static Method getMethodAndNoArgs(Class<?> clazz, String methodName) {
        Method method = null;
        try {
            return clazz.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            System.out.println(String.format(
                    "Method with name %s doesn't exists or not public in class %s",
                    methodName,
                    clazz.getSimpleName()
            ));
            return null;
        }
    }

    private static String[] getTestSuitAnnotationValues(Class<?> clazz) {
        if (clazz.isAnnotationPresent(TestSuite.class)) {
            return clazz.getDeclaredAnnotation(TestSuite.class).value();
        }
        return null;
    }
}
/**
 * Create single-value annotation TestSuite with default element that returns array of strings.
 *  Create class TestSuitHandler with static method run(Class clazz).
 * This method invokes all public non-static zero args methods.
 * This method print to console information about all executed methods in form:
 *    -- Method <class>.<methodname> started --
 * <result of  methodname invocation>
 *   -- Method <class><methodname> finished --
 * (before -- should printed tab character)
 * If clazz doesn't contain the <methodName> defined in annotation information Method with name <methodName> doesn't exists or not public in class clazz should be displayed.
 * If clazz is not marked with TestSuite annotation message Class clazz isn't annotated  should be displayed.
 * For example
 * We have
 * @TestSuite({"m1", "m2"})
 * class Class1{
 *   public void m2(){
 *     System.out.println("Hello");
 *   }
 * }
 *
 * We run
 * TestSuiteHandler.run(Class1.class);
 *
 * As a result we have
 * Method with name m1 doesn't exists or not public in class Class1
 * 	 -- Method Class1.method2 started--
 * Hello
 * 	 -- Method Class1.method2 finished--
 */

class Test1 {
    public static void m1() {
        System.out.println("m1");
    }
    public static void m2() {
        System.out.println("m2");
    }
    public static void m3(String str) {
        System.out.println("m3 "+str);
    }
    public static void m4(int i) {
        System.out.println("m4 "+i);
    }
    public void m5() {
        System.out.println("m5 ");
    }
    public void m6(String str) {
        System.out.println("m6 ");
    }
}

//@TestSuite({"m1", "m2", "m3"})
class Class1{
    public void m2(){
        System.out.println("Hello");
    }
    public static void m3() {
        System.out.println("m3");
    }
    public void m4(String str) {
        System.out.println("m4 ");
    }
}

public class Task3 {
    public static void main(String[] args) {
        TestSuitHandler.run(Class1.class);
    }
}

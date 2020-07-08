package com.softserve.sprint07.task1;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CamelCase {}

class CheckCamelCase {
    public static final String CAMELCASE_PATTERN = "^[a-z]+[a-zA-Z0-9]*$";
    public static boolean checkAndPrint(Class type) {
        boolean result = true;
        Method[] methods = type.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(CamelCase.class)
                && !method.getName().matches(CheckCamelCase.CAMELCASE_PATTERN)) {
                System.out.println(String.format(
                        "method %s.%s doesn't satisfy camelCase naming convention",
                        type.getSimpleName(), method.getName()
                ));
                result = false;
            }
        }
        return result;
    }
}

class ClassForAnnot {
    @CamelCase
    public static void example() {
    }

    @CamelCase
    public void Example() {
    }

    public static void _main(String args[]) {
    }
}
/*public*/ class Class1{
    @CamelCase
    public void correct(){}
    @CamelCase
    public void InCorrect(){}
    @CamelCase
    public void JustMethod(){}
}

/*public*/ class Class2{
    @CamelCase
    public void correct(){}
    @CamelCase
    public void oneMoreCorrect(){}
}


/**
 * Create marker-annotation CamelCase which will check whether method named according to code conventions.
 * Create class CheckCamelCase for checking if all the annotated methods of some class satisfy naming pattern.
 * This class contains constant 'CAMELCASE_PATTERN' that introduces regex for checking method name.
 * Also this class contains method checkAndPrint(Class class) which returns
 * true if all annotated methods of class satisfy 'CAMELCASE_PATTERN'
 * and throws Exception with information about all incorrect method names by template:
 * method <className>.<methodName> doesn't satisfy camelCase naming convention.
 *
 * For example:
 *
 * For class
 * public class Class1{
 * @CamelCase
 * public void correct(){}
 * @CamelCase
 * public void InCorrect(){}
 * public void JustMethod(){}
 * }
 * call CheckCamelCase.checkAndPrint(Class1.class)
 * prints to console
 * method Class1.InCorrect doesn't satisfy camelCase naming convention
 */
public class Task1 {
    public static void main(String[] args) throws Exception {
        System.out.println(CheckCamelCase.checkAndPrint(Class1.class));
    }
}


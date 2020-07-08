package com.softserve.sprint06.task5;

import java.util.HashSet;
import java.util.function.Predicate;
import java.util.Set;

class MyUtils{
    static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicateSet) {
//        Predicate<Integer> result = x -> true;
//        for (Predicate<Integer> predicate : predicateSet) {
//            result = result.and(predicate);
//        }
//        return result;
        return predicateSet.stream().reduce(x->true, (acc, cur) -> acc.and(cur));
    }
}

/**
 * Implement a static method getPredicateFromSet(...) in MyUtils class.
 *
 * The getPredicateFromSet method should take a Set of predicates working with integers as a parameter
 * and return a predicate with the functionality of all predicates in the set invoked and connected by logical AND.
 */
public class Task5 {
    public static void main(String[] args) {
        Set<Predicate<Integer>> predicateSet = new HashSet<Predicate<Integer>>() {{
            add(new Predicate<Integer>() {
                @Override
                public boolean test(Integer x) {
                    return x > 10;
                }
            });
            add(x -> x > 15);
            add(x -> x > 20);
        }};

        Predicate<Integer> result = MyUtils.getPredicateFromSet(predicateSet);
        System.out.println(result.test(Integer.valueOf(18)));
        System.out.println(result.test(Integer.valueOf(19)));
        System.out.println(result.test(Integer.valueOf(20)));
        System.out.println(result.test(Integer.valueOf(21)));
        System.out.println(result.test(Integer.valueOf(22)));
    }
}

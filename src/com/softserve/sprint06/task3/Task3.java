package com.softserve.sprint06.task3;

import java.util.Collections;
import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*public*/ class App {

    public static BinaryOperator<String> greetingOperator = (parameter1, parameter2) ->
            "Hello " + parameter1 + " " + parameter2 + "!!!";

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> operator){
        return people
                .stream()
                .filter(person -> person != null)
                .map(person ->
                    operator.apply(person.name, person.surname)
                ).collect(Collectors.toList());
    }
//    public static List<String> createGreetings(List<Person> people,BinaryOperator<String> greetingOperator){
//        List<String> greetings=new ArrayList<> ( );
//        for(Person p: people)
//            greetings.add(greetingOperator.apply ( p.name,p.surname ));
//        return greetings;
//    }
}

/**
 * Add to App class static field greetingOperator of type BinaryOperator .
 *
 * The greetingOperator should create a new string as a result by the rule:
 * "Hello " + parameter1 + " " + parameter2 + "!!!"
 *
 * Create a static method createGreetings(...) that takes two parameters:
 * List<Person> and BinaryOperator and generates List<String> as a result.
 * We should be able to pass greetingOperator as a parameter here.
 *
 * Please, use the second parameter in creating the result.
 */

class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

public class Task3 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>() {{
            add(new Person("Oleg", "Berd"));
            add(new Person("Helen", "Berd"));
//            add(null);
            add(new Person("Viktor", "Berd"));
            add(new Person("Sam", "Berd"));
        }};
        App.createGreetings(personList, App.greetingOperator).stream().forEach(System.out::println);
    }
}

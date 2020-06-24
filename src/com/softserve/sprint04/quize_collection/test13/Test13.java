package com.softserve.sprint04.quize_collection.test13;

import java.util.HashSet;
import java.util.Set;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
public class Test13 {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("Ivan"));
        set.add(new Student("Petro"));
        set.add(new Student("Ivan"));
        System.out.println(set); // ->  [Ivan, Ivan, Petro] or [Ivan, Petro, Ivan]  or [Petro, Ivan, Ivan]
    }
}

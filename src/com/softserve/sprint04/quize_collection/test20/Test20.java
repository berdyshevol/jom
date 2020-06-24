package com.softserve.sprint04.quize_collection.test20;

import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student> {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student student) {
        return name.compareTo(student.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
public class Test20 {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();
        set.add(new Student("Ivan"));
        set.add(new Student("Petro"));
        set.add(new Student("Ivan"));
        System.out.println(set); // -> [Ivan, Petro]
    }
}

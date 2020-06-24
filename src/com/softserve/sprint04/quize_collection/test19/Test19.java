package com.softserve.sprint04.quize_collection.test19;

import java.util.Set;
import java.util.TreeSet;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
public class Test19 {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();
        set.add(new Student("Ivan")); // Exception in thread "main" java.lang.ClassCastException: com.softserve.sprint04.quize_collection.test19.Student cannot be cast to java.lang.Comparable
        set.add(new Student("Petro"));
        set.add(new Student("Ivan"));
        System.out.println(set);
    }
}

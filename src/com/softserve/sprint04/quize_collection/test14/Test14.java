package com.softserve.sprint04.quize_collection.test14;

import java.util.HashSet;
import java.util.Set;

class Student1 {
    private String name;

    public Student1(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student1 student1 = (Student1) o;

        return name != null ? name.equals(student1.name) : student1.name == null;
    }

    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String toString() {
        return name;
    }
}
public class Test14 {
    public static void main(String[] args) {
        Set<Student1> set = new HashSet<>();
        set.add(new Student1("Ivan"));
        set.add(new Student1("Petro"));
        set.add(new Student1("Ivan"));
        System.out.println(set); // -> [Ivan, Petro]
    }
}

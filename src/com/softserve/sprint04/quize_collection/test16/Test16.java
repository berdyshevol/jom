package com.softserve.sprint04.quize_collection.test16;

import java.util.HashSet;
import java.util.Set;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    //    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return name != null ? name.equals(student.name) : student.name == null;
    }

//    @Override
//    public int hashCode() {
//        return name != null ? name.hashCode() : 0;
//    }

    public String toString() {
        return name;
    }
}
public class Test16 {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("Ivan"));
        set.add(new Student("Petro"));
        set.add(new Student("Ivan"));
        System.out.println(set); // ->  [Ivan, Ivan, Petro] or [Ivan, Petro, Ivan] or [Petro, Ivan, Ivan]
    }
}

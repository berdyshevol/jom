package com.softserve.sprint04.task6;

public class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}


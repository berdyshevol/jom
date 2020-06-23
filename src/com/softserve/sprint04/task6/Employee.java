package com.softserve.sprint04.task6;

public class Employee extends Person {
    private final double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
    public String toString() {
        return super.toString() + ", Salary: " + salary;
    }
}

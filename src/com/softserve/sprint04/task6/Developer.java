package com.softserve.sprint04.task6;

public class Developer extends Employee {
    private final Level level;

    public Developer(String name, int age, double salary, Level level) {
        super(name, age, salary);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public String toString() {
        return super.toString() + ", Level: " + level.name();
    }
}

package com.softserve.sprint05.task3;

enum Type {
    RARE, ORDINARY;

    @Override
    public String toString() {
        return Utils.capitalize(this.name());
    }
}

enum Color {
    WHITE, RED, BLUE;

    @Override
    public String toString() {
        return Utils.capitalize(this.name());
    }
}

class Utils {
    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}

class ColorException extends Exception {
    public ColorException(String message) {
        super(message);
    }
}

class TypeException extends Exception {
    public TypeException(String message) {
        super(message);
    }
}
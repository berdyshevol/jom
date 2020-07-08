package com.softserve.sprint05.task2;

/**
 * Create a class Plant, which includes private fields String name, Color color and Type type,
 * and constructor with three String parameters   (String type, String color, String name) where these fields are initialized.
 * Create getters for all fields.
 * Color and Type are Enum.
 * Color contains White, Red, Blue entries.
 * Type contains Rare and Ordinary entries.
 * Override the method toString( ) for Plant class which returns result formatted like following: {type: Rare, color: Red, name: MyPlant}
 * Create classes ColorException and TypeException as derived from Exception.
 * Both classes should have a constructor with one String parameter and pass this parameter to the base class.
 * The constructor of Plant should throw a corresponding exception whenever an inappropriate parameter is passed.
 */

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

class Plant {
    private String name;
    private Color color;
    private Type type;

    public Plant(String type, String color, String name) throws ColorException, TypeException {
        this.name = name;
        this.color = convertToColor(color);
        this.type = convertToType(type);
    }

    private Color convertToColor(String color) throws ColorException {
        if (color == null) throw new ColorException("Invalid value Grey for field color");
        if (color.toUpperCase().equals(Color.WHITE.name())) return Color.WHITE;
        else if (color.toUpperCase().equals(Color.RED.name())) return Color.RED;
        else if (color.toUpperCase().equals(Color.BLUE.name())) return Color.BLUE;
        else throw new ColorException("Invalid value Grey for field color");
    }

    private Type convertToType(String type) throws TypeException { // TODO: redo!!!!!!!!!!!!!!
        if (type == null) throw new TypeException("Invalid value Unknown type for field type");
        if (type.toUpperCase().equals(Type.RARE.name())) return Type.RARE;
        else if(type.toUpperCase().equals(Type.ORDINARY.name())) return Type.ORDINARY;
        else throw new TypeException("Invalid value Unknown type for field type");
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return  "{" +
                "type: " + type +
                ", color: " + color +
                ", name: " + name +
                '}';
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

public class Task2 {
    public static void main(String[] args) throws Exception{
        Plant plant = new Plant("RARE", "RED", "rose");
        System.out.println(plant);
        Plant plant1 = new Plant("Rare", "RED", "MyPlant");
        System.out.println(plant1);
    }
}

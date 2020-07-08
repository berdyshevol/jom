package com.softserve.sprint05.task3;

/**
 * Suppose, we class Plant from the task2, which includes private fields String name, Color color and Type type,
 * and constructor with three String parameters where these fields are initialized. Color and Type are Enum.
 * Color contains White, Red, Blue entries.
 * Type contains Rare and Ordinary entries.
 *
 * And we have classes ColorException and TypeException as derived from Exception.
 *
 * The constructor of Plant throws a corresponding exception whenever an inappropriate parameter is passed:
 * String type, String color, String name.
 * Write a static tryCreatePlant method that takes 3 string parameters - type, color and name and returns an instance of Plant,
 * created based on passed params. (Don't create any classes, write as if you are already inside a class.)
 * The tryCreatePlant method should catch exceptions that can be thrown by Plant constructor.
 * If inappropriate type passed as a parameter, a Plant object should be returned anyway, with Ordinary type.
 * If an inappropriate color is passed, set Red color for created instance.
 */

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

    private Type convertToType(String type) throws TypeException {
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


public class Task3 {
    public static Plant tryCreatePlant(String type, String color, String name) {
        Plant result = null;
        try {
            result = new Plant(type, color, name);
        } catch (TypeException e) {
            try {
                result = new Plant("ORDINARY", color, name);
            } catch (ColorException e1) {
                try {
                    result = new Plant("ORDINARY", "RED", name);
                } catch (Exception e2) {
                    System.out.println("Here");
                    e1.printStackTrace();
                }
            }
        } catch (ColorException e1) {
            try {
                result = new Plant(type, "RED", name);
            } catch (TypeException e2) {
                try {
                    result = new Plant("ORDINARY", "RED", name);
                } catch (Exception e3) {
                    System.out.println("or here");
                    e3.printStackTrace();
                }
            }
        }
        finally {
            return result;
        }
    }

    public static void main(String[] args) {
        Plant p1 = tryCreatePlant("qq", "ss", "rose");
        System.out.println(p1);

        Plant p2 = tryCreatePlant("qq", "WHITE", "rose");
        System.out.println(p2);

        Plant p3 = tryCreatePlant("RARE", "ss", "rose");
        System.out.println(p3);
    }
}

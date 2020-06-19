package task06;

import java.util.*;
import java.util.stream.Collectors;

abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    abstract double getArea();

    public String getName() {
        return this.name;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    double getArea() {
        return this.height * this.width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;

        Rectangle rectangle = (Rectangle) o;

        if (Double.compare(rectangle.width, width) != 0) return false;
        return Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(width);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

public class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {
        ArrayList<Shape> result = new ArrayList<>();
        if (isValidList(shapes)) {
            double maxCircleArea = Collections.max(
                    shapes,
                    Comparator.comparing(shape -> shape instanceof Circle ? ((Shape)shape).getArea() : 0)
            ).getArea();
            double maxRectArea = Collections.max(
                    shapes,
                    Comparator.comparing(shape -> shape instanceof Rectangle ? ((Shape)shape).getArea() : 0)
            ).getArea();
            result = removeDuplicates(shapes)
                    .stream()
                    .filter(shape ->
                            (shape instanceof Circle && ((Shape) shape).getArea() == maxCircleArea)
                            || (shape instanceof Rectangle && ((Shape) shape).getArea() == maxRectArea)
                    )
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        return result;
    }

    private boolean isValidList(List<?> list) {
        if (list == null || list.size() == 0 || list.stream().anyMatch(item -> item == null)) {
            return false;
        }
        return true;
    }
    // ВОПРОС: этот метод removeDuplicates у меня повторяется во всех заданиях. Но он зависит от типа элементов списка
    // есть ли возможность, чтобы он был универсальным (то есть одинаковым)
    private List<Shape> removeDuplicates(List<Shape> list) {
        return new ArrayList<>(new HashSet<>(list));
    }

    public static void main(String[] args) {
        ArrayList<Shape> list = new ArrayList<>();
        list.add(new Circle("Circle", 2.0));
        list.add(new Rectangle("Rectangle", 2.0, 3.0));
        list.add(new Circle("Circle", 1.0));
        list.add(new Rectangle("Rectangle", 3.0, 2.0));
        list.add(new Circle("Circle", 0.5));
        list.add(new Rectangle("Rectangle", 1.0, 2.0));

        System.out.println(new MyUtils().maxAreas(list));
    }
}

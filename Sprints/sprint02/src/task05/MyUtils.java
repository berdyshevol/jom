package task05;

import java.util.ArrayList;
import java.util.List;

interface IPerimeter {
    public double getPerimeter();
}

class Rectang implements IPerimeter {
    private double width;
    private double height;

    public Rectang(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }
}
class Square implements IPerimeter {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return 4 * this.width;
    }
}
public class MyUtils {
    public double sumPerimeter(List<?> figures) {
        if (!isValidList(figures)) {
            return 0;
        }
        return figures
                .stream()
                .map(figure -> ((IPerimeter)figure).getPerimeter())
                .reduce(0.0, Double::sum);
    }

    private boolean isValidList(List<?> list) {
        if (list == null || list.size() == 0
                || list.stream().anyMatch(item -> item == null)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<IPerimeter> list = new ArrayList<>();
        list.add(new Square(4.0));
        list.add(new Square(5.0));
        list.add(new Rectang(2.0, 3.0));
        list.add(new Rectang(2.0, 3.0));
        System.out.println(new MyUtils().sumPerimeter(list));
    }
}

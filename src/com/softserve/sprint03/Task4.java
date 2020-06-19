package com.softserve.sprint03;

public class Task4 {
    enum LineType {
        SOLID,
        DOTTED,
        DASHED,
        DOUBLE
    }

    public static String drawLine(LineType lineType) {
        return String.format(
                "The line is %s type", lineType.toString().toLowerCase()
        );
    }

    public static void main(String[] args) {
        System.out.println(drawLine(LineType.SOLID));
    }
}

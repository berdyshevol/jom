package com.softserve.sprint09.task1;

import java.time.LocalDate;

/**
 * Write a method to check if a year is a leap year or not, using for this the LocalDate class.
 *
 * If a year is leap then method should return true, otherwise - false.
 */
public class Task1 {
    public static boolean isLeapYear(int year) {
        return LocalDate.of(year, 1, 1).isLeapYear();
    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(1952)); // true
        System.out.println(isLeapYear(1974)); // false
        System.out.println(isLeapYear(2020)); // true
        System.out.println(isLeapYear(2000)); // true
        System.out.println(isLeapYear(1900)); // false
    }
}

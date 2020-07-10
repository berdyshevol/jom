package com.softserve.sprint09.task2;

import java.time.LocalDate;

/**
 * Write a method to get the date n-years m-months and k-days after today using new DateTime API.
 *
 * Return the obtained date in the format ISO_LOCAL_DATE.
 */
public class Task2 {
    public static String getDateAfterToday(int years, int months, int days) {
        return LocalDate.now()
                .plusYears(years)
                .plusMonths(months)
                .plusDays(days)
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(getDateAfterToday(3, 18, 27)); //        2025-02-05
        System.out.println(getDateAfterToday(-2, 5, 18)); //        2018-12-27
        System.out.println(getDateAfterToday(8, 0, 24)); //        2028-08-02
        System.out.println(getDateAfterToday(2, -37, 9)); //       2019-06-18
        System.out.println(getDateAfterToday(0, 0, 0)); //        2020-07-09
    }
}

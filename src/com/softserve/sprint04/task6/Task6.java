package com.softserve.sprint04.task6;

import java.util.Arrays;
import java.util.Comparator;

class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1 == null && o2 == null) return 0;
        else if (o1 == null) return -1;
        else if (o2 == null) return 1;
        else return o1.compareTo(o2);
    }
}

class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int compare = (new StringComparator()).compare(o1.getName(), o2.getName());
        return  compare != 0
                ? compare
                : o1.getAge() - o2.getAge();
    }
}

class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int compare = (new PersonComparator()).compare(o1, o2);
        return  compare != 0
                ? compare
                : (int) (o1.getSalary() - o2.getSalary());
    }
}

class DeveloperComparator implements Comparator<Developer> {
    @Override
    public int compare(Developer o1, Developer o2) {
        int compare = (new EmployeeComparator()).compare(o1, o2);
        return compare != 0
                ? compare
                : convertEnumToInt(o1.getLevel()) - convertEnumToInt(o2.getLevel());
    }

    private int convertEnumToInt(Level level) {
        switch (level) {
            case JUNIOR: return 1;
            case MIDDLE: return 2;
            case SENIOR: return 3;
        }
        return 0;
    }
}

class Utility {
    public static <T extends Person> void sortPeople(T[] list, Comparator<? super T> comparator) {
        Arrays.sort(list, comparator);
    }
    public static <T extends String> void sortPeople(T[] list, Comparator<? super T> comparator) {
        Arrays.sort(list, comparator);
    }
}

public class Task6 {
    public static void main(String[] args) {

        /* Test String */
//        String [] list = new String[] {
//                "Nick",
//                "Sara",
//                "Bart",
//                "Nick",
//                "Sara",
//                "Bart"
//        };
//        Arrays.stream(list).forEach(System.out::println);
//        System.out.println();
//        Utility.sortPeople(list, (new StringComparator()));
//        Arrays.stream(list).forEach(System.out::println);
//        for (int i = 0; i < list.length - 1; i++) {
//            System.out.println(list[i]);
//        }

//        /* Test Person */
//        Person[] personList = new Person[] {
//                new Person("Nick", 27),
//                new Person("Sara", 24),
//                new Person("Bart", 38),
//                new Person("Nick", 21),
//                new Person("Sara", 24),
//                new Person("Bart", 38),
//        };
//        Arrays.stream(personList).forEach(System.out::println);
//        System.out.println();
//        Utility.sortPeople(personList, new PersonComparator());
//        Arrays.stream(personList).forEach(System.out::println);

        /* Test Employee*/
//        Employee[] employeesList = new Employee[] {
//                new Employee("Nick", 27, 2850.55),
//                new Employee("Sara", 24, 2950.35),
//                new Employee("Bart", 38, 3165.75),
//                new Employee("Nick", 21, 1940.25),
//                new Employee("Sara", 24, 2260.65),
//                new Employee("Bart", 38, 3165.75),
//        };
//        Arrays.stream(employeesList).forEach(System.out::println);
//        System.out.println();
//        Utility.sortPeople(employeesList, new EmployeeComparator());
//        Arrays.stream(employeesList).forEach(System.out::println);

        /* Test Developer */
        Developer[] employeesList = new Developer[] {
                new Developer("Nick", 27, 2850.55, Level.MIDDLE),
                new Developer("Sara", 24, 2950.35, Level.SENIOR),
                new Developer("Bart", 38, 3165.75, Level.MIDDLE),
                new Developer("Nick", 21, 1940.25, Level.JUNIOR),
                new Developer("Sara", 24, 2260.65, Level.MIDDLE),
                new Developer("Bart", 38, 3165.75, Level.JUNIOR),
        };
        Arrays.stream(employeesList).forEach(System.out::println);
        System.out.println();
        Utility.sortPeople(employeesList, new DeveloperComparator());
        Arrays.stream(employeesList).forEach(System.out::println);

    }
}

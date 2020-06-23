package com.softserve.sprint04.task2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class MyUtils {
    public static class Student {
        private final int id;
        private final String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        private boolean has(List<Student> list) {
            for (Student studentFromList : list) {
                if (this.equals(studentFromList)) return true;
            }
            return false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            if (id != student.id) return false;
            return name != null ? name.equals(student.name) : student.name == null;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }

    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        Set<Student> result = new HashSet<>();
        if (list1 != null || list2 != null) {
            for (Student student : list1) {
                if (student == null) continue;
                if (student.has(list2)) {
                    result.add(student);
                }
            }
        }
        return result;
    }
}

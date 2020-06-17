package task03;

import java.util.*;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Student extends Person {
    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (studyYears != student.studyYears) return false;
        return studyPlace.equals(student.studyPlace);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + studyPlace.hashCode();
        result = 31 * result + studyYears;
        return result;
    }
}

class Worker extends Person {
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        if (!super.equals(o)) return false;

        Worker worker = (Worker) o;

        if (experienceYears != worker.experienceYears) return false;
        return workPosition.equals(worker.workPosition);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + workPosition.hashCode();
        result = 31 * result + experienceYears;
        return result;
    }
}

class SuperPerson {
    private int experienceYears;
    private int studyYears;
    SuperPerson(Person person) {
        this.experienceYears = -1;
        this.studyYears = -1;
        if (person instanceof Worker) {
            this.experienceYears = ((Worker) person).getExperienceYears();
        } else if (person instanceof Student) {
            this.studyYears = ((Student) person).getStudyYears();
        }
    }

    public int getExperienceYears() {
        return this.experienceYears;
    }

    public int getStudyYears() {
        return this.studyYears;
    }
}

/*public*/ class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {
        ArrayList<Person> result = new ArrayList<>();
        if (isValidList(persons)) {
            List<Person> noDuplicates = removeDuplicates(persons);
            ArrayList<SuperPerson> superPersons = convertToSuperPersonList(noDuplicates);
            int maxExperienceYears = getMaxExperienceYears(superPersons);
            int maxStudyYears = getMaxStudyYears(superPersons);
            for (Person person : noDuplicates) {
                if (person instanceof Student) {
                    if (((Student) person).getStudyYears() == maxStudyYears) {
                        result.add(person);
                    }
                } else if (person instanceof Worker) {
                    if (((Worker) person).getExperienceYears() == maxExperienceYears) {
                        result.add(person);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValidList(List<?> list) {
        if (list == null || list.size() == 0 || list.stream().anyMatch(item -> item == null)) {
            return false;
        }
        return true;
    }

    private int getMaxExperienceYears(List<SuperPerson> superPersons) {
        Comparator<SuperPerson> compareByExperienceYears = Comparator.comparing(SuperPerson::getExperienceYears);
        return superPersons.stream().max(compareByExperienceYears).get().getExperienceYears();
    }

    private int getMaxStudyYears(List<SuperPerson> superPersons) {
        Comparator<SuperPerson> compareByStudyYears = Comparator.comparing(SuperPerson::getStudyYears);
        return superPersons.stream().max(compareByStudyYears).get().getStudyYears();
    }

    private ArrayList<SuperPerson> convertToSuperPersonList(List<Person> persons) {
        ArrayList<SuperPerson> result = new ArrayList<>();
        for (Person person: persons) {
            result.add(new SuperPerson(person));
        }
        return result;
    }

    private List<Person> removeDuplicates(List<Person> list) {
        return new ArrayList<>(new HashSet<>(list));
    }
}

public class Task03 {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Ivan"));
        list.add(new Student("Petro", "University", 3));
        list.add(new Student("Petro", "University", 3));
        list.add(new Worker("Andriy", "Developer", 12));
        list.add(new Worker("Andriy", "Developer", 12));
        list.add(new Worker("Andriy", "Developer", 12));
        list.add(new Student("Stepan", "College", 4));
        list.add(new Student("Stepan", "College", 4));
        list.add(new Worker("Ira", "Manager", 8));
        list.add(new Student("Ihor", "University", 4));
        List<Person> persons = new MyUtils().maxDuration(list);
        System.out.println(persons);
    }
}

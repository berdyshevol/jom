package task04;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (experience != employee.experience) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return basePayment != null ? basePayment.equals(employee.basePayment) : employee.basePayment == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + experience;
        result = 31 * result + (basePayment != null ? basePayment.hashCode() : 0);
        return result;
    }
}

class Manager extends Employee {
    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public BigDecimal getPayment() {
        return super.getPayment().multiply(new BigDecimal(this.coefficient)).setScale(2); // TODO:
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;

        Manager manager = (Manager) o;

        return Double.compare(manager.coefficient, coefficient) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(coefficient);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

public class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {
        ArrayList<Employee> result = new ArrayList<>();
        if (workers == null || workers.size() == 0
                || workers.stream().anyMatch(worker -> worker == null)) {
            return result;
        }
        ArrayList<Employee> noDuplicates = new ArrayList<>(new HashSet<>(workers));
        int maxExperience = maximalExperience(noDuplicates);
        BigDecimal maxPayment = maximalPayment(noDuplicates);
        result = noDuplicates
                .stream()
                .filter(
                        employee ->
                                employee.getExperience() == maxExperience
                                        || employee.getPayment().compareTo(maxPayment) == 0
                )
                .collect(Collectors.toCollection(ArrayList::new));
        return result;
    }

    private int maximalExperience(List<Employee> employees) {
        return employees
                .stream()
                .max(
                        Comparator.comparing(Employee::getExperience)
                )
                .get()
                .getExperience();
    }

    private BigDecimal maximalPayment(List<Employee> employees) {
        return employees.
                stream()
                .max(
                        Comparator.comparing(Employee::getPayment)
                ).get().getPayment();
    }

    public static void main(String[] args) {
        ArrayList<Employee> workers = new ArrayList<>();
        workers.add(new Employee("Ivan", 10, new BigDecimal("3000.00"))); // v
        workers.add(new Manager("Petro", 9, new BigDecimal("3000.00"), 1.5)); // v
        workers.add(new Employee("Stepan", 8, new BigDecimal("4000.00")));
        workers.add(new Employee("Andriy", 7, new BigDecimal("3500.00")));
        workers.add(new Employee("Ihor", 5, new BigDecimal("4500.00"))); // v
        workers.add(new Manager("Vasyl", 8, new BigDecimal("2000.00"), 2.0));
        workers.add(null);

        workers.add(new Employee("Ivan", 10, new BigDecimal("3000.00"))); // v
        workers.add(new Manager("Petro", 9, new BigDecimal("3000.00"), 1.5)); // v
        workers.add(new Employee("Stepan", 8, new BigDecimal("4000.00")));
        workers.add(new Employee("Andriy", 7, new BigDecimal("3500.00")));
        workers.add(new Employee("Ihor", 5, new BigDecimal("4500.00"))); // v
        workers.add(new Manager("Vasyl", 8, new BigDecimal("2000.00"), 2.0));
        workers.add(null);

        workers.add(new Employee("Ivan", 10, new BigDecimal("3000.00"))); // v
        workers.add(new Manager("Petro", 9, new BigDecimal("3000.00"), 1.5)); // v
        workers.add(new Employee("Stepan", 8, new BigDecimal("4000.00")));
        workers.add(new Employee("Andriy", 7, new BigDecimal("3500.00")));
        workers.add(new Employee("Ihor", 5, new BigDecimal("4500.00"))); // v
        workers.add(new Manager("Vasyl", 8, new BigDecimal("2000.00"), 2.0));
        workers.add(null);

        List<Employee> largestEmployees = new MyUtils().largestEmployees(workers);
    }
}

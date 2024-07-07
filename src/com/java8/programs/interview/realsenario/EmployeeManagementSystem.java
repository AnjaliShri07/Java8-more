package com.java8.programs.interview.realsenario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

class EmployeeManagement {
    private List<Employee> employees;

    public EmployeeManagement() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public Optional<Employee> findEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();

        management.addEmployee(new Employee(1, "John Doe", "Engineering"));
        management.addEmployee(new Employee(2, "Jane Smith", "Marketing"));
        management.addEmployee(new Employee(3, "Emily Johnson", "Sales"));

        System.out.println("Employees in the company:");
        management.displayEmployees();

        management.removeEmployee(2);

        System.out.println("\nEmployees in the company after removal:");
        management.displayEmployees();

        System.out.println("\nSearching for employee with ID 3:");
        Optional<Employee> employee = management.findEmployeeById(3);
        employee.ifPresent(System.out::println);
    }
}

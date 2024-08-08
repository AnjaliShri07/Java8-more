package com.java8.programs.interview.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String empId; // Employee ID as a String to handle digit extraction

    // Constructor
    public Employee(String name, String empId) {
        this.name = name;
        this.empId = empId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmpId() {
        return empId;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', empId='" + empId + "'}";
    }

    // Method to get a specific digit from the employee ID
    public int getDigitFromEmpId(int position) {
        // Handle cases where position is out of bounds
        if (position < 1 || position > empId.length()) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        // Return the digit at the specified position (1-based index)
        return Character.getNumericValue(empId.charAt(position - 1));
    }
}
public class SortUsingDynamicId {
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "12345"));
        employees.add(new Employee("Bob", "98765"));
        employees.add(new Employee("Charlie", "54321"));

        int position = 2; // Specify the position of the digit to sort by (1-based index)

        // Sort employees by the specified digit of empId
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingInt(e -> Character.getNumericValue(e.getEmpId().charAt(position-1))))
                .toList();

        // Print sorted employees
        sortedEmployees.forEach(System.out::println);
    }
}

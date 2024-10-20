package com.java8.programs.interview.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employees1 {
    private String name;
    private Integer age;
    private String company;

    public Employees1(String name, Integer age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}';
    }
}
public class SecondMostAgebasedOnCompany {
    public static void main(String[] args) {

        List<Employees1> empList = Arrays.asList(
                new Employees1("Alice", 30, "CompanyA"),
                new Employees1("Bob", 60, "CompanyA"),
                new Employees1("Charlie", 55, "CompanyA"),
                new Employees1("David", 35, "CompanyB"),
                new Employees1("Eve", 40, "CompanyB"),
                new Employees1("Frank", 50, "CompanyC"),
                new Employees1("Grace", 60, "CompanyC"),
                new Employees1("Anita", 60, "CompanyC"),
                new Employees1("Heidi", 55, "CompanyC"),
                new Employees1("Sarah", 55, "CompanyC")
        );

        Map<String, Employees1> secondOldestByCompany = empList.stream()
                // Group employees by company
                .collect(Collectors.groupingBy(
                        Employees1::getCompany,
                        // Sort by age and ensure distinct ages
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .map(Employees1::getAge)  // Map employees to their ages
                                        .distinct()             // Get distinct ages
                                        .sorted(Comparator.reverseOrder()) // Sort ages in descending order
                                        .skip(1)   // Skip the oldest to get the 2nd most aged
                                        .findFirst()
                                        .flatMap(secondAge -> list.stream()
                                                .filter(e -> e.getAge()  == secondAge)
                                                .findFirst()
                                        )
                                        .orElse(null) // Handle cases where no second age exists
                        )
                ));

        // Print the result
        secondOldestByCompany.forEach((company, employee) ->
                System.out.println("Company: " + company + ", 2nd most aged employee: " + employee)
        );

    }
}

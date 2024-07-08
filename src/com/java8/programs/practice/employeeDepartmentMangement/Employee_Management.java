package com.java8.programs.practice.employeeDepartmentMangement;

import java.util.*;
import java.util.stream.Collectors;

public class Employee_Management {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Ram Chandra", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Joey Moore", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));


        //How many male and female employees are there in the organization?
        Map<String, Long> countByGender = employeeList.stream().collect(Collectors.groupingBy(Employee :: getGender, Collectors.counting()));
        System.out.println("Gender in organization : " + countByGender);
        System.out.println("************************************************************************************************************");

        //Print the name of all departments in the organization?
        List<String> departmentList = employeeList.stream().map(Employee :: getDepartment).distinct().toList();
        System.out.println("Department List : "+ departmentList);
        System.out.println("************************************************************************************************************");

        //What is the average age of male and female employees?
        Map<String, Double> averageAgeBasedOnGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee :: getGender, Collectors.averagingInt(Employee :: getAge)));

        System.out.println("average Age Based On Gender : "+ averageAgeBasedOnGender);
        System.out.println("************************************************************************************************************");

        //Get the details of highest paid employee in the organization
        Optional<Employee> highestSalaryEmployee = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Highest Salary Employee : "+ highestSalaryEmployee);
        System.out.println("************************************************************************************************************");

        //Get the names of all employees who have joined after 2015
        List<String> employeeNameAfter2015 = employeeList.stream().filter(y-> y.getYearOfJoining() > 2015).map(Employee :: getName).toList();
        System.out.println("Employee Name Joined After2015 : "+ employeeNameAfter2015);
        System.out.println("************************************************************************************************************");

        //Count the number of employees in each department
        Map<String, Long> employeeCountByDepartment = employeeList.stream()
                    .collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.counting()));
        System.out.println("Employee Count By Department : "+ employeeCountByDepartment);
        System.out.println("************************************************************************************************************");

        //What is the average salary of each department
        Map<String, Double> avgSalaryByDepartment = employeeList.stream()
                                                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee :: getSalary)));
        System.out.println("Average Salary By Department : "+ avgSalaryByDepartment);
        System.out.println("************************************************************************************************************");

        //Get the details of youngest male employee in the product development department
        Optional<Employee> youngestMaleEmployeeDetail = employeeList.stream()
                                                            .filter(a-> a.gender.equalsIgnoreCase("Male")
                                                                    && a.getDepartment().equalsIgnoreCase("Product Development"))
                                                            .min(Comparator.comparingInt(Employee::getAge));
        System.out.println("Youngest Male Employee in the product development department : "+ youngestMaleEmployeeDetail);
        System.out.println("************************************************************************************************************");

        //Who has the most working experience in the organization
        Optional<Employee> mostExperiencedEmployee = employeeList.stream().sorted(Comparator.comparingInt(Employee:: getYearOfJoining)).findFirst();
        System.out.println("Most Experienced Employee : "+ mostExperiencedEmployee);
        System.out.println("************************************************************************************************************");

        //How many male and female employees are there in the sales and marketing team
        Map<String, Long> MaleAndFemaleCountForSalesAndMarketingDept = employeeList.stream().filter(d-> d.getDepartment().equalsIgnoreCase("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Male And Female Count For Sales And Marketing Dept : "+ MaleAndFemaleCountForSalesAndMarketingDept);
        System.out.println("************************************************************************************************************");


        //What is the average salary of male and female employees
        Map<String, Double> averageSalaryByGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average Salary By Gender : "+ averageSalaryByGender);
        System.out.println("************************************************************************************************************");

        //List down the names of all employees in each department
        Set<Map.Entry<String, List<Employee>>> name = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)).entrySet();

        /*Map<String, List<Employee>> mapList = name.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        List<Employee> empList = mapList.values().stream().iterator().next().stream().toList();
        System.out.println("NEW WAY : " + empList.stream().map(Employee::getName).toList());*/

        for (Map.Entry<String, List<Employee>> entry : name)
        {
            System.out.println("--------------------------------------");
            System.out.println("Employees In " + entry.getKey() + " : ");
            System.out.println("--------------------------------------");
            List<Employee> list1 = entry.getValue();

            for (Employee e : list1)
                System.out.println(e.getName());
        }
        System.out.println("************************************************************************************************************");

    //What is the average salary and total salary of the whole organization
     DoubleSummaryStatistics employeeSalaryStatistics =
                employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

     System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());
     System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());
     System.out.println("************************************************************************************************************");

    //Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years
        Set<Map.Entry<Boolean, List<Employee>>> entrySet = employeeList.stream()
                                                            .collect(Collectors.partitioningBy(e->e.getAge() > 25)).entrySet();
        for (Map.Entry<Boolean, List<Employee>> entry : entrySet)
        {
            System.out.println("----------------------------");
            if (entry.getKey())
                 System.out.println("Employees older than 25 years :");
            else
                System.out.println("Employees younger than or equal to 25 years :");

            System.out.println("----------------------------");

            List<Employee> list = entry.getValue();
            for (Employee e : list)
                System.out.println(e.getName());
        }
        System.out.println("************************************************************************************************************");

        //Who is the oldest employee in the organization? What is his age and which department he belongs to
        Optional<Employee> oldestEmployee = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println("Age of oldest employee in the org : "+ oldestEmployee.get().getAge());
        System.out.println("Department of oldest employee in the org : "+ oldestEmployee.get().getDepartment());
    }

}

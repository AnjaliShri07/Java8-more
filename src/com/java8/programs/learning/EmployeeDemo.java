package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDemo {
	
	public static List<EmployeeJava8> getEmployeeName(List<EmployeeJava8> l, String firstName){
		return l.stream().filter(i->i.getFirstName().equalsIgnoreCase(firstName)).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		EmployeeJava8[] employees = {
		         new EmployeeJava8("J", "Red", 51000, "IT"),
		         new EmployeeJava8("A", "Green", 71600, "IT"),
		         new EmployeeJava8("M", "Black", 35187.5, "Sales"),
		         new EmployeeJava8("K", "Yellow", 47100.77, "Marketing"),
		         new EmployeeJava8("L", "Pink", 62001, "IT"),
		         new EmployeeJava8("D", "Blue", 32001, "Sales"),
		         new EmployeeJava8("W", "Brown", 42361.4, "Marketing")};

		      // get List view of the Employees
		      List<EmployeeJava8> list = Arrays.asList(employees);

		      // display all Employees
		      System.out.println("Complete Employee list:");
		      list.stream().forEach(System.out::println);
		      
		      // average of Employee salaries with DoubleStream average method
		      System.out.printf("Average of Employees' salaries: %.2f%n",
		         list.stream()
		             .mapToDouble(EmployeeJava8::getSalary)
		             .average()
		             .getAsDouble()); 
		      System.out.println("Double Salary:");
		      list.stream().mapToDouble(i->i.getSalary()*2).forEach(System.out::println);
		      
		      List<EmployeeJava8> nameEmp = new ArrayList<>();
		      nameEmp = getEmployeeName(list, "J");
		      System.out.println(nameEmp);
		      
		      list.stream().map(i-> i.getSalary()).collect(Collectors.toList()).forEach(System.out::println);
	}

}

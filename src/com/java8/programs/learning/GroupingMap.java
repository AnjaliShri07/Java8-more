package com.java8.programs.learning;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class GroupingMap {
	 public static void main(String args[]) throws IOException   
	    {  
	        List<EmployeeGrouping> emp = new ArrayList<>();  
	        emp.add(new EmployeeGrouping("Dipak", "Delhi", 21));  
	        emp.add(new EmployeeGrouping("Sumit", "Delhi", 21));  
	        emp.add(new EmployeeGrouping("Karan", "Delhi", 23));  
	        emp.add(new EmployeeGrouping("Mona", "Udaipur", 23));  
	        emp.add(new EmployeeGrouping("Rajesh", "Banglore", 23));  
	        emp.add(new EmployeeGrouping("Niraj", "Banglore", 31)); 
	        
	        /* Group by Employees by city before Java 8 world */         
	        Map<String,List<EmployeeGrouping>> EmpByCity = new HashMap<>();  
	          
	        for(EmployeeGrouping p : emp)  
	        {  
	            if(!EmpByCity.containsKey(p.getCity()))  
	            {  
	                EmpByCity.put(p.getCity(), new ArrayList<>());                  
	            }  
	            EmpByCity.get(p.getCity()).add(p);  
	        }  
	        System.out.println("grouped by cities before Java 8 : " + EmpByCity);        
	        
	        /* group objects of Employee class in Java 8 */  
	        EmpByCity =  emp.stream().collect(Collectors.groupingBy(EmployeeGrouping::getCity));  
	        System.out.println("grouped by cities: " + EmpByCity);  
	        
	        /* group Employees by age */  
	        Map<Integer,List<EmployeeGrouping>> EmpByAge = emp.stream().collect(Collectors.groupingBy(EmployeeGrouping::getAge));  
	        System.out.println("grouped by age: " + EmpByAge); 
	        
	        /* sort by Name */
	        Collections.sort(emp, Comparator.comparing(EmployeeGrouping::getName));
	        emp.forEach(System.out::println);
	        
	        /* sort by Name And Age*/
	        emp.sort(Comparator.comparing(EmployeeGrouping::getName).thenComparing(EmployeeGrouping::getAge)); 
	        emp.forEach(System.out::println);
	        
	        System.out.println("*******************************************************************************");
	        
	        List<Employee2> employees = new ArrayList<>();

	        employees.add(new Employee2(1, "John", 1000));
	        employees.add(new Employee2(1, "Peter", 2000));
	        employees.add(new Employee2(1, "Ben", 3000));
	        employees.add(new Employee2(1, "Steve", 2000));
	        employees.add(new Employee2(1, "Parker", 1000));
	        
	        Map<Integer, Set<String>> EmpSalary = employees.stream().collect(Collectors.groupingBy(Employee2::getSalary, Collectors.mapping
                    (Employee2::getName, Collectors.toSet()))); 
	        System.out.println("*******************************************************************************");
	        System.out.println("Employee Grouped by Salary: " + EmpSalary);
	        
	        //List<EmployeeGrouping> empList =  employees.sort((EmployeeGrouping e1, EmployeeGrouping e2) -> e1.getName().compareTo(e2.getName()));
	       
	        employees.add(new Employee2(1, "a", 1000));
	        employees.add(new Employee2(2, "b", 2000));
	        employees.add(new Employee2(3, "c", 3000));
	        employees.add(new Employee2(1, "a", 2000));
	        employees.add(new Employee2(2, "b", 1000));
	   
	        
	     }  
	}  
	

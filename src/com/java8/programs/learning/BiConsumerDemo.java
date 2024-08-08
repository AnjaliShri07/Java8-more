package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.function.BiConsumer;

class Employee1{
	
	String name;
	Double salary;
	Employee1(String name, Double salary){
		this.name = name;
		this.salary = salary;
	}
}

public class BiConsumerDemo {
	public static void populate(ArrayList<Employee1> l) {
		l.add(new Employee1("Durga", 10000.0));
		l.add(new Employee1("Ravi", 20000.0));
		l.add(new Employee1("Shiva", 30000.0));
		l.add(new Employee1("Pavan", 40000.0));
	}

	public static void main(String[] args) {
		ArrayList<Employee1> l = new ArrayList<Employee1>();
		populate(l);
		BiConsumer<Employee1, Double> c = (e, d)-> e.salary=e.salary + d;
		for (Employee1 e : l) {
			c.accept(e, 500.0);
		}
		for (Employee1 e : l) {
			System.out.println("Employee Name : " +e.name);
			System.out.println("Employee salary : " +e.salary);
			System.out.println();
		}

	}

}
 
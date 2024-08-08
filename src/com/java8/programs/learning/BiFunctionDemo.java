package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.function.BiFunction;


class Employee{
	int eno;
	String name;
	Employee(int eno, String name){
		this.eno = eno;
		this.name = name;
	}
}

public class BiFunctionDemo {


	public static void main(String[] args) {
		ArrayList<Employee> l = new ArrayList<Employee>();
		BiFunction<Integer, String, Employee> f = (eno, name) -> new Employee(eno, name); 
		l.add(f.apply(100, "Durga"));
		l.add(f.apply(200, "Ravi"));
		l.add(f.apply(300, "Shiva"));
		l.add(f.apply(400, "Pavan"));
		for(Employee e : l) {
			System.out.println("Employee No : " +e.eno);
			System.out.println("Employee Name : " +e.name);
			System.out.println();
		}
	}

}

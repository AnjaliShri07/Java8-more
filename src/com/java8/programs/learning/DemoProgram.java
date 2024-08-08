package com.java8.programs.learning;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Student1{
	String name;
	int marks;

	Student1(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class DemoProgram {

	public static void main(String[] args) {
		Function<Student1, String> f = s -> {
			int marks = s.marks;
			String grade ="";
			if(marks >= 80) grade = "A[Dictinction]";
			else if(marks >= 60) grade = "B[First Class]";
			else if(marks >= 50) grade = "C[Second Class]";
			else if(marks >= 35) grade = "D[Third Class]";
			else grade= "E[Failed]";
			return grade;
		};
		
		Predicate<Student1> p = s -> s.marks >= 60;
		
		Consumer<Student1> c = s1->{
			System.out.println("Student name : " + s1.name);
			System.out.println("Student marks: " + s1.marks);
			System.out.println("Student grade: " + f.apply(s1));
			System.out.println();
		};

		Student1[] s = { new Student1("Durga", 100),
				new Student1("Sunny", 65),
				new Student1("Bunny", 55),
				new Student1("Chinny", 45),
				new Student1("Vinny", 30)
				};
		/*// For Predicte 
		for(Student s1 : s) {  
			if(p.test(s1)) {
				System.out.println("Student name : " + s1.name);
				System.out.println("Student marks: " + s1.marks);
				System.out.println("Student grade: " + f.apply(s1));
				System.out.println();
			}
		}
		*/
		//For consumer
		for(Student1 s1 : s) {
			if(p.test(s1))
			c.accept(s1);
		}

	}

}

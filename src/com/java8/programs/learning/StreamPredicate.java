package com.java8.programs.learning;

import java.util.Arrays;
import java.util.List;

public class StreamPredicate {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");
		
		for(String name : names) {
			if(!name.equals("Sam")) {
				System.out.println("For Loop: "+ name);
			}
		}
		
		names.stream()
		.filter(name-> !name.equals("Sam"))
		.forEach(System.out::println);
	}

}

package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Reference to instance method from class type
public class ExampleWithMethodRefer1 {

	public static void main(String[] args) {
		 List<String> names = new ArrayList<String>();
	        names.add("Ram");
	        names.add("Sham");
	        names.add("Krishan");
	        names.add("Nony");
	                
	     
	        List<String> sorted = names.stream()
	                .sorted((s1, s2) -> s1.compareTo(s2))
	                .collect(Collectors.toList());
	        System.out.println(sorted);
	        
	        List<String> sortedAlt = names.stream()
	                .sorted(String::compareTo)
	                .collect(Collectors.toList());
	        System.out.println(sortedAlt);
	}

}


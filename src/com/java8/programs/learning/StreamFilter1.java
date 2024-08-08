package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter1 {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("Anjali");
		names.add("Sheela");
		names.add("Ram");
		names.add("Sunita");
		names.add("Sanju");
		names.add("Shahid");
		List<String> result = names.stream().filter(s->s.startsWith("S")).sorted().
                collect(Collectors.toList()); 
		System.out.println(result); 
	}

}

package com.java8.programs.learning;

import java.util.Arrays;
import java.util.List;

public class StreamIsEmpty {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

		//get count of empty string
		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println(count);
		
		
		long count1 = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("parallelStream : " + count1);
	}

}

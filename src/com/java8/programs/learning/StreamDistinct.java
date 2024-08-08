package com.java8.programs.learning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinct {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		//get list of unique squares
		//List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList()); //print square of distinct items
		List<Integer> squaresList = numbers.stream().distinct().collect(Collectors.toList()); //print distinct items
		squaresList.forEach(System.out::println);
	}

}

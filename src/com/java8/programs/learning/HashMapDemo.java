package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<String, Integer> m = new java.util.HashMap<String, Integer>();
		m.put("five", 5);
		m.put("two", 2);
		m.put("nine", 9);
		m.put("four", 4);
		m.put("six", 6);
		
		//List<Entry<String, Integer>> entries = new ArrayList<>(m.entrySet());
		//Collections.sort(entries, (o1,o2) -> o1.getKey().compareTo(o2.getKey()));
		
		m.entrySet().stream().sorted(Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("****************************");
		m.entrySet().stream().sorted(Entry.comparingByValue()).forEach(System.out::println);
		
		System.out.println("--------EXAMPLE---------------");
		
		// Convert String to Uppercase and join them using coma
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada"); 
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", ")); 
		System.out.println(G7Countries);   
		
		// Create List of square of all distinct numbers 
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4); 
		List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);   
		
		//Get count, min, max, sum, and average for numbers 
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29); 
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics(); 
		System.out.println("Highest prime number in List : " + stats.getMax()); 
		System.out.println("Lowest prime number in List : " + stats.getMin()); 
		System.out.println("Sum of all prime numbers : " + stats.getSum()); 
		System.out.println("Average of all prime numbers : " + stats.getAverage());
		
		System.out.println("--------HIGHEST & LOWEST---------------");
		
		Integer highest = Stream.of(1, 2, 3, 77, 6, 5)
				.max(Comparator.comparing(Integer::valueOf))
				.get();

		/* We have used max() method with Comparator.comparing() method
to compare and find the highest number 
		 */

		Integer lowest = Stream.of(1, 2, 3, 77, 6, 5)
				.min(Comparator.comparing(Integer::valueOf))
				.get();

		/* We have used max() method with Comparator.comparing() method
to compare and find the highest number 
		 */

		System.out.println("The highest number is: " + highest);
		System.out.println("The lowest number is: " + lowest);


		
	}

}

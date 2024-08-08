package com.java8.programs.learning;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo1 {

	public static void main(String[] args) throws IOException {
	/*
		IntStream
		.range(1, 10)
		.forEach(System.out::println);
	*/
		
	/*
		IntStream
		.range(1, 10)
		.skip(5)
		.forEach(x->System.out.println(x));
		*/
		
		
		/*
		//Integer Stream with sum
		System.out.println(
		IntStream
		.range(1, 5)
		.sum());
		System.out.println();
		*/
		
		
		/*
		Stream.of("Ava", "Aneri", "Alberto")
		.sorted()
		.findFirst()
		.ifPresent(System.out::println);
		*/
		
		/*
		String[] names = {"Al", "Sarika", "Kushal", "Brent", "amanda","Hans", "Shivika","Sarah"};
		Arrays.stream(names)     // same as Stream.of(names)
		.filter(x -> x.startsWith("S"))
		.sorted()
		.forEach(System.out::println);
		*/
		
		
		/*
		//average of square of an int array
		Arrays.stream(new int[] {2,3,4,5,6,7,8,9,10})
		.map(x-> x*x)
		.average()
		.ifPresent(System.out::println);
		*/
		
		/*
		//Stream from List, filter and print
		List<String> people = Arrays.asList("Al", "Sarika", "Kushal", "Brent", "amanda","Hans", "Shivika","Sarah");
		people
				.stream()
				.map(String :: toLowerCase)
				.filter(x -> x.startsWith("a"))
				.forEach(System.out::println);
		*/
		
		/*
		//Stream rows from text file
		Stream<String> bands = Files.lines(Paths.get("D:\\bands.txt"));
		bands
			.sorted()
			.filter(x-> x.length() > 13)
			.forEach(System.out::println);
		bands.close();
		*/
		
		/*
		Stream<String> bands2 = Files.lines(Paths.get("D:\\StreanEx.txt"));
		bands2
			.filter(x-> x.contains("re"))
			.collect(Collectors.toList());
		bands2.forEach(x -> System.out.println(x));
		*/
		
	//A Stream should be operated on (invoking an intermediate or terminal stream operation) only once. 
	//A Stream implementation may throw IllegalStateException if it detects that the Stream is being reused.	
	}

}

package com.java8.programs.learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseElement {
	public static String reverse(String string) {
        return Stream.of(string)
            .map(word->new StringBuilder(word).reverse())
            .collect(Collectors.joining(" "));
    }
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 8};
		List<Integer> list = Arrays.stream(arr)        // IntStream
                					.boxed()    // Stream<Integer>
                					.collect(Collectors.collectingAndThen(
                								Collectors.toList(),
                									l -> {Collections.reverse(l); return l; }
		        )
		);
	//Collections.reverse(Arrays.asList(arr));
		System.out.println(list);
		
		System.out.println("Reverse String : "+ reverse("student"));
	}

}

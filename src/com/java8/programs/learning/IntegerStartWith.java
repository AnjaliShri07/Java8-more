package com.java8.programs.learning;

import java.util.Arrays;
import java.util.List;

public class IntegerStartWith {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10, 11, 30, 40, 121, 60);
		list.stream().map(s-> s+ "").filter(s-> s.startsWith("1")).forEach(System.out :: println);

	}

}

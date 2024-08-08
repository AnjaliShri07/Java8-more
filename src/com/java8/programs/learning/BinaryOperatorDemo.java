package com.java8.programs.learning;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {
	public static void main(String[] args) {
		//BiFunction<String, String, String> f = (s1, s2)->s1+s2;
		 BinaryOperator<String> f = (s1, s2)->s1+" "+s2;
		System.out.println(f.apply("durga", "software"));
	}
}
 
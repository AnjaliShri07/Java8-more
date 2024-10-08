package com.java8.programs.learning;

import java.util.function.BiPredicate;

public class BiPredicateDemo {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> p= (a,b) ->(a+b) % 2==0;
		System.out.println(p.test(10, 20));
		System.out.println(p.test(30, 25));
	}

}

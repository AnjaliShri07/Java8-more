package com.java8.programs.learning;

import java.util.function.IntPredicate;

public class IntPredicateDemo {

	public static void main(String[] args) {
		//Predicate<Integer> p=i-> i%2==0;
		IntPredicate p=i-> i%2==0;
		System.out.println(p.test(10));
	}
//int --> Integer --> int
	//10 is int type but predicate retuen type is Integer so Predicate internally convert int to Integer.
	//IntPredicate interface is there for int value.
}

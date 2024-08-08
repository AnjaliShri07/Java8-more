package com.java8.programs.learning;

import java.util.function.IntUnaryOperator;

public class IntUnaryOperatorDemo {

	public static void main(String[] args) {
		IntUnaryOperator f = i-> i+1;
		System.out.println(f.applyAsInt(4));
		
		IntUnaryOperator f1 = i-> i*i;
		System.out.println(f1.applyAsInt(4));
		
		System.out.println(f.andThen(f1).applyAsInt(4));

	}

}

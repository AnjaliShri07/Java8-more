package com.java8.programs.learning;

import java.util.function.IntBinaryOperator;

public class IntBinaryOperatorDemo {

	public static void main(String[] args) {
		IntBinaryOperator f = (i1,i2)->i1 * i2;
		System.out.println(f.applyAsInt(10, 20));
	}

}

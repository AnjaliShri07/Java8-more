package com.java8.programs.learning;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOpreatorDemo {

	public static void main(String[] args) {
		/*
		 UnaryOperator<Integer> f = i-> i*i;
		System.out.println(f.apply(5));
		*/
		IntUnaryOperator f = i-> i*i;
		System.out.println(f.applyAsInt(6));
		

	}

}

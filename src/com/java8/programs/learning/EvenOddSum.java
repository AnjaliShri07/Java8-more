package com.java8.programs.learning;

import java.util.Arrays;


public class EvenOddSum {

	public static void main(String[] args) {
		int[] array = { 1,2,3,4,5,6,7,8,9,10 };
		int sum = Arrays.stream(array).map(i -> i % 2 == 0 ? i*i : 0).sum();
		System.out.println(sum);
		
		int sumReduce = Arrays.stream(array).filter(i-> i%2==0).map(i->i*i).reduce(0, Integer::sum);
		System.out.println("Using Reduce :" + sumReduce);
		
		int sumMethod = Arrays.stream(array).filter(i-> i%2==0).map(i->i*i).sum();
		System.out.println("Using sum() :" + sumMethod);
		
		int oddsum = Arrays.stream(array).map(i -> i % 2 == 1 ? i*i : 0).sum();
		System.out.println("oddsum : "+ oddsum);

	}

}

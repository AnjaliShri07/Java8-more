package com.java8.programs.learning;

public class LambdaDemo1 {
	interface Addable {
		int add(int a, int b);
	}

	public static void main(String[] args) {
		Addable sum = (a, b) -> (a + b);
		System.out.println(sum.add(10, 20));

		Addable ad2 = (a, b) -> {
			return (a + b);
		};
		System.out.println(ad2.add(100, 200));
	}

}

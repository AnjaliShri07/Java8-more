package com.java8.programs.learning;

public class LambdaParameters {
interface Addable{
	int addition(int a, int b);
}
	public static void main(String[] args) {
		Addable abcAddable = (a, b)->{
			int c= (a+b);
			return c;
		};

	}

}

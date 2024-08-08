package com.java8.programs.learning;

import java.util.function.Function;

public class StaticMethod {

	public static void main(String[] args) {
		 //Calling parseInt() method using lambda
        Function<String, Integer> lambdaExpression = (a) -> Integer.parseInt(a);
        System.out.println(lambdaExpression.apply("5"));
         
        //Calling parseInt() method using method reference
        Function<String, Integer> methodReference = Integer::parseInt;
        System.out.println(methodReference.apply("5"));

	}

}

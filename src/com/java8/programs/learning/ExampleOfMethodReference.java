package com.java8.programs.learning;

import java.util.function.BiFunction;
import java.util.function.Function;

class OperatorByMethodRefer
{  
    public static int add(int a, int b)
    {  
        return a+b;  
    }  
    public static String upperCase(String a)
    {  
        return a.toUpperCase();  
    }  
}  
public class ExampleOfMethodReference {

	public static void main(String[] args) {
		 BiFunction<Integer, Integer, Integer> addInt = OperatorByMethodRefer::add;  
         Function<String, String> upperString = OperatorByMethodRefer::upperCase;  
         System.out.println(addInt.apply(5, 8));  
         System.out.println(upperString.apply("javagoal")); 
	}

}

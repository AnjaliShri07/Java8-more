package com.java8.programs.learning;

class Sample1{
	Sample1(String s){
		System.out.println("Sample class Constructo Execution... with arg " + s);
	}
}

interface Interf2{
	public Sample1 get(String s);
}
public class ConstructorRef2 {

	public static void main(String[] args) {
		Interf2 i = Sample1 :: new;
		Sample1 s1 = i.get("Java8");
		Sample1 s2 = i.get("C++");

	}

}

package com.java8.programs.learning;


class Sample{
	Sample(){
		System.out.println("Sample class Constructo Execution...");
	}
}

interface Interf1{
	public Sample get();
}

public class ConstructorRef1 {

	public static void main(String[] args) {
		Interf1 i = Sample :: new;
		Sample s1 = i.get();
	}

}
//Interf1 get() refer Sample class Constructor
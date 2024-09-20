package com.java8.programs.learning;

interface Interf{
	 void add(int a, int b);
}
public class MethodDemo {
	
	public static void sum(int x,int y) {
		System.out.println("The Sum : " + (x+y));
	}
	
	public static void main(String[] args) {
		Interf i = (a,b)-> System.out.println("The Sum : " + (a+b));
		i.add(10, 20);
		
		Interf i1 = MethodDemo :: sum;
		i.add(300, 400);
	}

}

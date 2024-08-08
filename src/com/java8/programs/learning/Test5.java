package com.java8.programs.learning;

public class Test5 {

	private int m1(int x) {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread-1");
		}
		return 10;
	}
	public static void main(String[] args) {
		Test5 t5 = new Test5();
		//Runnable r = t5 :: m1; // different return type so Error
		//Thread t = new Thread(r);
		//t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread-1");
		}

	}

}
//actual and formal arg lists differ in length
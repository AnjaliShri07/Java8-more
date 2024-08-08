package com.java8.programs.learning;

public class Test3 {
	/*
	public static void m1() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread-1");
		}
	}
	*/
	
	private int m1() {
		//for (int i = 0; i < 10; i++) {
		int i=0;
		while(i < 10) {
			System.out.println("Child Thread-1");
			i++;
		}
		return 10;
	}

	public static void main(String[] args) {
		/*
		Runnable r = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Child Thread");
			}
		};
		*/
		
		//Runnable r = Test3 :: m1;
		
		Test3 t3 = new Test3();
		Runnable r = t3::m1;
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread-1");
		}
	}

}

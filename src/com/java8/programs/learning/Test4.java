package com.java8.programs.learning;

public class Test4 {
	
	public void m1() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread-1");
		}
	}

	public static void main(String[] args) {
		Test4 t4 = new Test4();
		Runnable r = t4 :: m1;
		
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread-1");
		}

	}

}

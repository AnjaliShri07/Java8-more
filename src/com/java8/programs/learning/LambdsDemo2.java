package com.java8.programs.learning;

public class LambdsDemo2 {
	interface Drawable{  
	    public void draw(int width);  
	}  
	public static void main(String[] args) {
		Drawable d = a -> System.out.println(a);
		d.draw(15);

	}

}


package com.java8.programs.learning;

import java.util.ArrayList;

public class StreamForEach1 {

	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(5);
		l.add(2);
		l.add(1);
		l.add(9);
		l.add(4);
		System.out.println(l);
		
		l.stream().forEach(i->{
			System.out.println("The Square of " + i+ " is : "+ (i*i));
		});

	}

}

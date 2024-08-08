package com.java8.programs.learning;

import java.util.ArrayList;


public class StreamMin {

	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(5);
		l.add(2);
		l.add(1);
		l.add(9);
		l.add(4);
		System.out.println(l);
		Integer min = l.stream().min((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Minimum : " + min);
		Integer max = l.stream().max((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Maximum : " + max);
	}

}

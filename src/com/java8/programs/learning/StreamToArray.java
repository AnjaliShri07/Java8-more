 package com.java8.programs.learning;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamToArray {

	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(5);
		l.add(2);
		l.add(1);
		l.add(9);
		l.add(4);
		System.out.println(l);
		Integer[] i= l.stream().toArray(Integer[] :: new);
		/*
		for(Integer i1 : i) {
			System.out.println(i1);
		}
		*/
		Stream.of(i).forEach(System.out::println); 
	}

}

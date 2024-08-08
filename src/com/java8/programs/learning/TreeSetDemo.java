package com.java8.programs.learning;

import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		//TreeSet<Integer> t = new TreeSet<Integer>((i1, i2)->(i1>i2)?-1:(i1<i2)?1:0);  //DESC
		
		//TreeSet<Integer> t = new TreeSet<Integer>((i1, i2)->i1.compareTo(i2));    //ASC
		TreeSet<Integer> t = new TreeSet<Integer>((i1, i2)->i2.compareTo(i1));    //DESC
		t.add(10);
		t.add(0);
		t.add(5);
		t.add(20);
		t.add(8);
		t.add(46);
		System.out.println(t);

	}

}

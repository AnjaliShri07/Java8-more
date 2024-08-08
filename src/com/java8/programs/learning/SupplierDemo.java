package com.java8.programs.learning;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		Supplier<Date> sp = ()-> new Date();
		System.out.println(sp.get());
		System.out.println(sp.get());
	}
}

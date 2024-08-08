package com.java8.programs.learning;

import java.util.function.Supplier;

public class SupplierRandom {

	public static void main(String[] args) {
		Supplier<String> sp = ()->{
			String otp="";
			int i=0;
			//for(int i=0; i<6; i++) {
			while(i < 6){
				otp= otp + (int)(Math.random()*10);
				i++;
			}
			return otp;
		};
		System.out.println(sp.get());
		System.out.println(sp.get());
		System.out.println(sp.get());
		System.out.println(sp.get());
		System.out.println(sp.get());
		System.out.println(sp.get());
		System.out.println(sp.get());
		System.out.println(sp.get());
		System.out.println(sp.get());
		System.out.println(sp.get());
	}

}

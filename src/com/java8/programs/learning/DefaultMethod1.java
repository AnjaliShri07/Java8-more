package com.java8.programs.learning;

interface Vehicle1 {

    default void print() {
        System.out.println("I am a vehicle!");
    }

    static void blowHorn() {
        System.out.println("Blowing horn!!!");
    }
}

interface FourWheeler1 {

    default void print() {
        System.out.println("I am a four wheeler!");
    }
}

class Car1 implements Vehicle1, FourWheeler1 {

    public void print() {
        // call the Vehicle interface default print method
        Vehicle1.super.print();
        FourWheeler1.super.print();
        // call the Vehicle interface static blowHorn method
        Vehicle1.blowHorn();
        System.out.println("I am a car!");
    }
}

public class DefaultMethod1 {
    public static void main(String args[]) {
        Vehicle1 vehicle1 = new Car1();
        vehicle1.print();
        // call the Vehicle interface static blowHorn method
        Vehicle1.blowHorn();
    }
}

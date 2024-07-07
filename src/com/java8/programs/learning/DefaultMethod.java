package com.java8.programs.learning;

interface Vehicle {
    default void print() {
        System.out.println("I am a vehicle!");
    }
}

interface FourWheeler {
    default void print() {
        System.out.println("I am a four wheeler!");
    }
}

class Car implements Vehicle, FourWheeler {
    // overriding the default method will resolve the ambiguity
    public void print() {
        System.out.println("I am a four wheeler car vehicle!");
    }

    public void print1() {
        Vehicle.super.print();
    }

    public void print2() {
        FourWheeler.super.print();
    }
}

public class DefaultMethod {
    public static void main(String args[]) {
        Car car = new Car();
        car.print();
        car.print1();
        car.print2();

        System.out.println("=====================");
        Vehicle vehicle = new Car();
        vehicle.print();
        ((Car) vehicle).print1();

        System.out.println("=====================");
        FourWheeler fourWheeler = new Car();
        fourWheeler.print();
        ((Car) fourWheeler).print2();
    }
}

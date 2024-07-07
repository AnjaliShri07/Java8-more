package com.java8.programs.learning;

public class SwitchYield {
    public static void main(String[] args) {
        System.out.println("Old Way");
        System.out.println(getDayTypeOld("Monday"));
        System.out.println(getDayTypeOld("Saturday"));
        //System.out.println(getDayTypeStyle2(""));
        System.out.println("===========================================");
        System.out.println("New Way");
        System.out.println(getDayTypeNew("Monday"));
        System.out.println(getDayTypeNew("Saturday"));
        //System.out.println(getDayType(""));
    }

    public static String getDayTypeNew(String day) {
        return switch (day) {
            // we can use block statements to return a value using yield after
            // executing other statements
            case "Monday", "Tuesday", "Wednesday","Thursday", "Friday" -> {
                yield "Weekday";
            }
            case "Saturday", "Sunday" -> {
                yield "Weekend";
            }
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
    }

    public static String getDayTypeOld(String day) {
        return switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                yield "Weekday";
            case "Saturday":
            case "Sunday":
                yield "Weekend";
            default:
                throw new IllegalStateException("Invalid day: " + day);
        };
    }
}

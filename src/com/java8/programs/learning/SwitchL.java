package com.java8.programs.learning;

public class SwitchL {
    public static void main(String[] args) {
        System.out.println("Old Switch");
        System.out.println(getDayTypeOldStyle("Monday"));
        System.out.println(getDayTypeOldStyle("Saturday"));
        System.out.println(getDayTypeOldStyle(""));

        System.out.println("New Switch");
        System.out.println(getDayType("Monday"));
        System.out.println(getDayType("Saturday"));
        System.out.println(getDayType(""));
    }

    public static String getDayType(String day) {
        // evaluate switch expression and get a value
        return switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
            case "Saturday", "Sunday" -> "Weekend";
            default -> "Invalid day.";
        };
    }
    public static String getDayTypeOldStyle(String day) {
        String result = null;
        // evaluate relevant cases and get a value into result variable
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                result = "Weekday";
                break;
            case "Saturday":
            case "Sunday":
                result = "Weekend";
                break;
            default:
                result =  "Invalid day.";
        }
        return result;
    }
}
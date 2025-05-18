package com.java8.programs.interview.GS;

import java.util.regex.Pattern;

public class PasswordStrengthChecker {
    public static String checkPasswordStrength(String password) {
        boolean hasLower = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasUpper = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("\\d").matcher(password).find();
        boolean hasSpecial = Pattern.compile("[!@#$%^&*()]").matcher(password).find();
        int length = password.length();

        if (hasLower && hasUpper && hasDigit && hasSpecial && length >= 8) {
            return "Strong";
        } else if (hasLower && hasUpper && hasSpecial && length >= 6) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }

    public static void main(String[] args) {
        String password1 = "gfg!@12"; // Example password
        String password2 = "SapientGlobalMarkets!@12"; // Example password

        System.out.println("Password: " + password1 + " - Strength: " + checkPasswordStrength(password1));
        System.out.println("Password: " + password2 + " - Strength: " + checkPasswordStrength(password2));
    }
}

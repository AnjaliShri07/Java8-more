package com.java8.programs.interview.GS;
/*Given a String, return the number of deletions to be made such that every adjacent character
in the string is adjacent character in the alphabet*/
public class AlphabeticalDeletions {
    public static int countDeletions(String s) {
        int deletions = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) + 1 != s.charAt(i + 1)) {
                deletions++;
            }
        }
        return deletions;
    }

    public static void main(String[] args) {
        String input = "abcfed";
        int deletions = countDeletions(input);
        System.out.println("Number of deletions needed: " + deletions);
    }

}

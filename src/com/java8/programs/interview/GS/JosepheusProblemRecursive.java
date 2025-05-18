package com.java8.programs.interview.GS;

public class JosepheusProblemRecursive {
    // Recursive function to find the winner
    public static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }

    public static void main(String[] args) {
        int n = 7; // Total number of people
        int k = 3; // k-th person will be eliminated

        int safePosition = josephus(n, k);
        System.out.println("The safe position is: " + safePosition);
    }
}

/*Complexity | Value
Time | O(n)
Space | O(n) (recursive stack)*/
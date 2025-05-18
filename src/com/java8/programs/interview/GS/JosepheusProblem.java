package com.java8.programs.interview.GS;

/*The Josephus Problem is a theoretical problem related to a certain elimination game.
People are standing in a circle waiting to be executed. Counting begins at a specified point in the circle and proceeds
around the circle in a fixed direction. After a specified number of people are skipped, the next person is executed.
This process is repeated with the remaining people until only one person remains and is freed.
The problem is to choose the position in the initial circle to avoid execution.*/
public class JosepheusProblem {
    // Iterative method to find the safe position
    public static int josephus(int n, int k) {
        //The variable result is initialized to 0. This represents the base case where there is only one person (n = 1),
        // and the survivor is at position 0 (0-based index).
        int result = 0; // Base case: josephus(1, k) = 0 in 0-based index
//This loop iterates from 2 to n (the total number of people).
//In each iteration, the position of the survivor is recalculated using the formula:
//result=(result+k)%i
//This formula updates the survivor's position considering the elimination of every k-th person.
        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }

        //Finally, the result is incremented by 1 to convert the 0-based index to a 1-based index,
        // which is more intuitive for most people.
        return result + 1; // Convert to 1-based index
    }

    public static void main(String[] args) {
        int n = 7; // Total number of people
        int k = 3; // Every k-th person is eliminated

        int safePosition = josephus(n, k);
        System.out.println("The safe position is: " + safePosition);
    }
}
/*📊 Complexity Analysis
✅ Time Complexity: O(n)
A single loop from 2 to n, each iteration doing constant work.

✅ Space Complexity: O(1)
No recursion, no extra data structures.*/
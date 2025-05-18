package com.java8.programs.interview.GS;

import java.util.*;
/*We have an array of integers temperatures which represents daily temperatures, return an
array waitDays such that waitDays[i] is the number of days you have to wait after the ith day
to get a warmer temperature. If there is no future day for which this is possible keep
waitDays[i] == 0.
I/P: temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
O/P : waitDays = [1,1,4,2,1,1,0,0]*/

/*o solve the problem of finding the number of days you have to wait for a warmer temperature, we can use a stack-based approach. This approach efficiently tracks the indices of the temperatures and helps determine the wait days for each temperature.

Approach
Initialize a Stack: Use a stack to keep track of the indices of the temperatures.
Iterate through the Temperatures: For each temperature, check if it is warmer than the temperature at the index stored
at the top of the stack.
Update Wait Days: If the current temperature is warmer, update the wait days for the index at the top of the stack
and pop the stack.
Push Current Index: Push the current index onto the stack.
Handle Remaining Indices: After iterating through the temperatures, any indices left in the stack will have a wait
day of 0.
Time Complexity
Time Complexity: O(n), where n is the number of temperatures. Each index is pushed and popped from the stack at most once.
Space Complexity: O(n) for the stack.*/
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] waitDays = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                waitDays[index] = i - index;
            }
            stack.push(i);
        }

        return waitDays;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] waitDays = dailyTemperatures(temperatures);
        System.out.println("Wait Days: " + Arrays.toString(waitDays));
    }
}

package com.java8.programs.interview.GS;

import java.util.*;
import java.util.stream.*;

/**
 * A group of students is sitting in a circle. The teacher is electing a new class president.
 * The teacher does this by singing a song while walking around the circle. After the song is
 * finished the student at which the teacher stopped is removed from the circle.
 * Starting at the student next to the one that was just removed, the teacher resumes singing and walking around the circle.
 * After the teacher is done singing, the next student is removed. The teacher repeats this until only one student is left.
 * A song of length k will result in the teacher walking past k students on each round. The students are numbered 1 to n. The teacher starts at student 1.
 * For example, suppose the song length is two (k=2). And there are four students to start with (1,2,3,4). The first
 * student to go would be `2`, after that `4`, and after that `3`. Student `1` would be the next president in this example.
 * @param n the number of students sitting in a circle.
 * @param k the length (in students) of each song.
 * @return the number of the student that is elected.
 */
public class Elections {
    public static int whoIsElected(int n, int k) {
        List<Integer> students = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList());

        int index = 0;

        while (students.size() > 1) {
            //Compute next removal index using (index + k - 1) % size
            //Remove the student at that index
            index = (index + k - 1) % students.size(); // move k-1 steps
            students.remove(index);
        }

        return students.get(0);
    }
    public static boolean doTestsPass() {
        int[][] testCases = {
                {1, 1, 1},
                {2, 2, 1},
                {4, 2, 1},
                {100, 2, 73},
                {5, 3, 4},
                {6, 4, 5},
                {1000, 5, 763}
        };

        for (int[] testCase : testCases) {
            int result = whoIsElected(testCase[0], testCase[1]);
            System.out.println(Elections.whoIsElected(testCase[0], testCase[1]));
            if (result != testCase[2]) {
                System.out.printf("Test failed: n=%d, k=%d, expected=%d, got=%d\n", testCase[0], testCase[1], testCase[2], result);
                return false;
            }
        }

        System.out.println("All tests passed");
        return true;
    }

    public static void main(String[] args) {
        doTestsPass();
    }
}
/*🔍 Explanation:
IntStream.rangeClosed(1, n) creates a stream of student numbers 1 to n.
.boxed().collect(Collectors.toList()) converts the IntStream to a List<Integer>.
The main logic runs a loop:
Compute next removal index using (index + k - 1) % size
Remove the student at that index
Repeat until one student remains.*/
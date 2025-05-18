package com.java8.programs.interview.GS;//Implement the 'walk' method.
//Assume robot initial position is (0,0).
//walk method take path where each character corresponds to a movement of the robot.
// The robot moves up, down, left, and right represented by the characters 'U', 'D', 'L', and 'R'
// Ignore other characters.

import java.util.Arrays;

/*Let's implement the walk method correctly so it follows the robot’s movements as described:
'U' (up): y + 1
'D' (down): y - 1
'L' (left): x - 1
'R' (right): x + 1
Ignore all other characters (like spaces or letters not in UDLR)*/
public class RobotMovement {
    // Returns the final coordinates after processing the path
    public static int[] walk(String path) {

        if (path == null || path.isEmpty()) {
            return new int[]{};
        }

        int x = 0, y = 0;

        for (char ch : path.toCharArray()) {
            switch (ch) {
                case 'U':
                case 'u':
                    y++;
                    break;
                case 'D':
                case 'd':
                    y--;
                    break;
                case 'L':
                case 'l':
                    x--;
                    break;
                case 'R':
                case 'r':
                    x++;
                    break;
                default:
                    break;
            }
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) {

        String str1 = "uuullddrrr";
         int[] finalPosition = RobotMovement.walk(str1);
         System.out.println("Final position for command \"" + str1 + "\": (" + finalPosition[0] + ", " + finalPosition[1] + ")");


}
}
/*💡 Explanation
We loop through the path string one character at a time.
For each valid direction character (U, D, L, R), we update the x or y position accordingly.
All invalid characters (like spaces or words like "LEFT") are ignored — as required.
At the end, we return the final coordinates as an Integer[].*/
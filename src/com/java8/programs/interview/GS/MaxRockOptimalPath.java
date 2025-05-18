package com.java8.programs.interview.GS;

/*
 ** Instructions to candidate.
 **  1) You are an avid rock collector who lives in southern California. Some rare
 **     and desirable rocks just became available in New York, so you are planning
 **     a cross-country road trip. There are several other rare rocks that you could
 **     pick up along the way.
 **
 **     You have been given a grid filled with numbers, representing the number of
 **     rare rocks available in various cities across the country.  Your objective
 **     is to find the optimal path from So_Cal to New_York that would allow you to
 **     accumulate the most rocks along the way.
 **
 **     Note: You can only travel either north (up) or east (right).
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement optimalPath() correctly.
 **  4) Here is an example:
 **                                                           ^
 **                 {{0,0,0,0,5}, New_York (finish)           N
 **                  {0,1,1,1,0},                         < W   E >
 **   So_Cal (start) {2,0,0,0,0}}                             S
 **                                                           v
 **   The total for this example would be 10 (2+0+1+1+1+0+5).
 */
public class MaxRockOptimalPath {
    public static Integer optimalPath(Integer[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        // Handle the case where the grid has only one element
        if (grid.length == 1 && grid[0].length == 1) return grid[0][0];

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        // Start from bottom-left (So_Cal)
        //We iterate from the bottom row (So_Cal) upward (i = rows - 1 → 0).
        //For each row, we go from left to right (j = 0 → cols - 1).
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                //fromSouth: if there's a cell below, get its dp value (coming from the south).
                //fromWest: if there's a cell to the left, get its dp value (coming from the west).
                //dp[i][j]: take current cell value grid[i][j] and add the maximum from either direction.
                int fromSouth = (i < rows - 1) ? dp[i + 1][j] : 0;
                int fromWest = (j > 0) ? dp[i][j - 1] : 0;
                dp[i][j] = grid[i][j] + Math.max(fromSouth, fromWest);
            }
        }
        //After the loop, dp[0][cols - 1] contains the maximum rocks collectible by following an optimal
        // path to the top-right corner (New_York).
        return dp[0][cols - 1]; // Top-right corner (New_York)
    }

    public static boolean doTestsPass() {
        boolean result = true;

        result &= optimalPath(new Integer[][]{
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}
        }) == 10;

        result &= optimalPath(new Integer[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }) == 12;

        result &= optimalPath(new Integer[][]{
                {1}
        }) == 1;

        result &= optimalPath(new Integer[][]{
                {1, 2, 3},
                {4, 5, 6}
        }) == 18;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(optimalPath(new Integer[][]{
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}
        }));
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}

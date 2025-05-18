package com.java8.programs.interview.GS;

import java.util.*;

/*
 Instructions:

 Given an empty chessboard (8x8 grid), a knight is placed
 on one of the squares. The knight 'K' at position (3, 3)
 and it's possible movements 'X' are shown in the example
 below:

 * * * * * * * *
 * * X * X * * *
 * X * * * X * *
 * * * K * * * *
 * X * * * X * *
 * * X * X * * *
 * * * * * * * *
 * * * * * * * *

 Depending on the knight's position on the board, 0-6 of
 the 8 possible movements may cause the knight to leave
 the chess board.

 If the knight moves n times, each time choosing one of
 the 8 possible moves uniformly at random, determine the
 probability that the knight is still on the board after
 making n random moves. After the knight has left the
 board, it may not reenter.

 Please implement the method probability which given a
 start position x, y, and a number of moves n,
 returns the probability a knight remains on the board
 as described above.
 */
public class KnightProbability {
    /* Top-Down Dynamic Programming with Memoization (Recursive DP)
Description:
A recursive function that tries all 8 knight moves at each step, using memoization (caching) to avoid recomputation.*/
    private static final int[][] MOVES = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    private final Map<String, Double> memo = new HashMap<>();

    public double probability(int x, int y, int n) {
        return dfs(x, y, n);
    }

    private double dfs(int x, int y, int movesLeft) {
        if (x < 0 || y < 0 || x >= 8 || y >= 8) return 0.0;
        if (movesLeft == 0) return 1.0;

        String key = x + "," + y + "," + movesLeft;
        if (memo.containsKey(key)) return memo.get(key);

        double prob = 0.0;
        for (int[] move : MOVES) {
            prob += dfs(x + move[0], y + move[1], movesLeft - 1) / 8.0;
        }

        memo.put(key, prob);
        return prob;
    }

    public static void main(String[] args) {
        KnightProbability solver = new KnightProbability();
        System.out.printf("Probability: %.6f\n", solver.probability(3, 3, 2));
    }
}

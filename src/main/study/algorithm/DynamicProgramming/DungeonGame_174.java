package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/dungeon-game/description/
 *
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 *
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 *
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *
 *
 * Note:
 *
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class DungeonGame_174 {

    public int calculateMinimumHP(int[][] dungeon) {
        /**
         * dp[i][j] 是到i，j点能survive的最小的health point
         *
         * m 行，h 列
         *
         * d[m-1][n-1] 是终点
         */

        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        dp[m-1][n-1] = dungeon[m-1][n-1] < 0 ? 1 - dungeon[m-1][n-1] : 1;

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (j > 0) {
                    if (dungeon[i][j-1] >= dp[i][j]) {
                        dp[i][j-1] = 1;
                    } else {

                        int tmp = dp[i][j] - dungeon[i][j-1];
                        if (dp[i][j-1] > 0)
                            dp[i][j-1] = Math.min(dp[i][j-1], tmp);
                        else
                            dp[i][j-1] = tmp;
                    }
                }
                if (i > 0) {
                    if (dungeon[i-1][j] >= dp[i][j]) {
                        dp[i-1][j] = 1;
                    } else {
                        int tmp = dp[i][j] - dungeon[i-1][j];
                        if (dp[i-1][j] > 0) {
                            dp[i-1][j] = Math.min(tmp, dp[i-1][j]);
                        } else
                            dp[i-1][j] = tmp;
                    }
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {

    }

}

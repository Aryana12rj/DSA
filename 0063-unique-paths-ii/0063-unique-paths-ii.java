import java.util.*;

class Solution {
    public int solve(int i, int j, int m, int n, int[][] dp, int[][] obstacleGrid) {
        // edge cases and managing obstacle FIRST
        if (i >= m || j >= n || i < 0 || j < 0 || obstacleGrid[i][j] == 1) {
            return 0;
        }

        // if we reach destination
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // precomputation
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // move right and down
        int right = solve(i, j + 1, m, n, dp, obstacleGrid);
        int down = solve(i + 1, j, m, n, dp, obstacleGrid);

        return dp[i][j] = right + down;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // if start or end is blocked
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];   // ✅ fixed size
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, m, n, dp, obstacleGrid);
    }
}

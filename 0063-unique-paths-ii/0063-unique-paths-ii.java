import java.util.*;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // fill first cell
        dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;

        // fill first row
        for (int col = 1; col < n; col++) {
            if (obstacleGrid[0][col] == 1) {
                dp[0][col] = 0;
            } else {
                dp[0][col] = dp[0][col - 1];
            }
        }

        // fill first col
        for (int row = 1; row < m; row++) {
            if (obstacleGrid[row][0] == 1) {
                dp[row][0] = 0;
            } else {
                dp[row][0] = dp[row - 1][0];
            }
        }

        // fill rest of grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}

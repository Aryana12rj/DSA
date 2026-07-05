import java.util.*;

class Solution {
    int n;
    char[][] board;
    int MOD = 1_000_000_007;
    int[][][] dp; // dp[i][j] = {maxScore, pathCount}

    public int[] pathsWithMaxScore(List<String> boardInput) {
        n = boardInput.size();
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = boardInput.get(i).toCharArray();
        }

        // initialize memo table
        dp = new int[n][n][2];
        for (int[][] row : dp) {
            for (int[] cell : row) Arrays.fill(cell, -2);
        }

        // start recursion from 'S' (bottom-right)
        int[] ans = dfs(n - 1, n - 1);
        if (ans[1] == 0) return new int[]{0, 0}; // no valid path
        return ans;
    }

    private int[] dfs(int i, int j) {
        // invalid cell
        if (i < 0 || j < 0 || board[i][j] == 'X') return new int[]{Integer.MIN_VALUE, 0};
        // base case: reached 'E'
        if (board[i][j] == 'E') return new int[]{0, 1};
        // memoized result
        if (dp[i][j][0] != -2) return dp[i][j];

        // recursive calls
        int[] up = dfs(i - 1, j);
        int[] left = dfs(i, j - 1);
        int[] diag = dfs(i - 1, j - 1);

        // find best score among moves
        int bestScore = Math.max(up[0], Math.max(left[0], diag[0]));
        long ways = 0;
        if (up[0] == bestScore) ways += up[1];
        if (left[0] == bestScore) ways += left[1];
        if (diag[0] == bestScore) ways += diag[1];

        if (bestScore == Integer.MIN_VALUE) {
            dp[i][j] = new int[]{Integer.MIN_VALUE, 0};
            return dp[i][j];
        }

        // add current cell value (skip 'S' and 'E')
        int val = (board[i][j] == 'S') ? 0 : board[i][j] - '0';
        dp[i][j][0] = bestScore + val;
        dp[i][j][1] = (int)(ways % MOD);

        return dp[i][j];
    }
}

class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][][] dp;

    private int helper(int i, int j, int k, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1; // Out of boundary
        }
        if (k == 0) {
            return 0; // No moves left
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        long ans = 0;
        ans += helper(i + 1, j, k - 1, m, n);
        ans += helper(i - 1, j, k - 1, m, n);
        ans += helper(i, j + 1, k - 1, m, n);
        ans += helper(i, j - 1, k - 1, m, n);

        dp[i][j][k] = (int)(ans % MOD);
        return dp[i][j][k];
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove + 1];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return helper(startRow, startColumn, maxMove, m, n);
    }
}

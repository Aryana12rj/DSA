class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][][] dp = new int[n][n][n][n];
        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int i2 = 0; i2 < n; i2++) {
                    for (int j2 = 0; j2 < n; j2++) {
                        dp[i1][j1][i2][j2] = -1;
                    }
                }
            }
        }
        return Math.max(0, solve(0, 0, 0, 0, grid, n, dp));
    }

    private int solve(int i1, int j1, int i2, int j2, int[][] grid, int n, int[][][][] dp) {
        // Out of bounds or thorn cell
        if (i1 >= n || j1 >= n || i2 >= n || j2 >= n ||
            grid[i1][j1] == -1 || grid[i2][j2] == -1) {
            return Integer.MIN_VALUE / 2; // avoid overflow
        }

        // Base case: reached bottom-right
        if (i1 == n - 1 && j1 == n - 1) {
            return grid[i1][j1] == 1 ? 1 : 0;
        }

        if (dp[i1][j1][i2][j2] != -1) return dp[i1][j1][i2][j2];

        int cherries = 0;
        if (i1 == i2 && j1 == j2) {
            // Both persons on same cell, count once
            cherries += (grid[i1][j1] == 1 ? 1 : 0);
        } else {
            // Different cells, count separately
            if (grid[i1][j1] == 1) cherries++;
            if (grid[i2][j2] == 1) cherries++;
        }

        // Explore 4 possible moves
        int cnt1 = solve(i1 + 1, j1, i2 + 1, j2, grid, n, dp);
        int cnt2 = solve(i1 + 1, j1, i2, j2 + 1, grid, n, dp);
        int cnt3 = solve(i1, j1 + 1, i2 + 1, j2, grid, n, dp);
        int cnt4 = solve(i1, j1 + 1, i2, j2 + 1, grid, n, dp);

        int best = Math.max(Math.max(cnt1, cnt2), Math.max(cnt3, cnt4));

        return dp[i1][j1][i2][j2] = cherries + best;
    }
}

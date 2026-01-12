class Solution {
    public int f(int i, int j, int[][] dp, int[][] grid) {
        // Base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        // Out of bounds
        if (i < 0 || j < 0) {
            return (int)1e9;
        }
        // Memoization check
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        // Recursive calls
        int up = grid[i][j] + f(i - 1, j, dp, grid);
        int left = grid[i][j] + f(i, j - 1, dp, grid);
        
        // Store and return minimum
        return dp[i][j] = Math.min(up, left);
    }
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Initialize dp with -1
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return f(m - 1, n - 1, dp, grid);
    }
}

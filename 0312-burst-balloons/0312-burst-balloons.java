import java.util.*;

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Add 1 at both ends to simplify boundary conditions
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // Memo table
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(arr, 1, n, dp);
    }

    private int solve(int[] arr, int left, int right, int[][] dp) {
        // Base case: no balloons left
        if (left > right) return 0;

        if (dp[left][right] != -1) return dp[left][right];

        int maxCoins = 0;
        // Try bursting each balloon last in [left..right]
        for (int i = left; i <= right; i++) {
            int coins = arr[left - 1] * arr[i] * arr[right + 1]
                      + solve(arr, left, i - 1, dp)
                      + solve(arr, i + 1, right, dp);
            maxCoins = Math.max(maxCoins, coins);
        }

        dp[left][right] = maxCoins;
        return maxCoins;
    }
}

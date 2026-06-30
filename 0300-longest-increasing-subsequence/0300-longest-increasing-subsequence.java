import java.util.*;

class Solution {
    int n;
    int[] nums;

    public int solve(int indx, int prev, int[][] dp) {
        if (indx == n) return 0;

        // Only check memo if prev is valid
        if (prev != -1 && dp[indx][prev] != -1) {
            return dp[indx][prev];
        }

        // Option 1: skip current
        int skip = solve(indx + 1, prev, dp);

        // Option 2: take current if valid
        int take = 0;
        if (prev == -1 || nums[prev] < nums[indx]) {
            take = 1 + solve(indx + 1, indx, dp);
        }

        // Store result only if prev is valid
        if (prev != -1) {
            dp[indx][prev] = Math.max(take, skip);
        }

        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        this.n = nums.length;
        this.nums = nums;

        int[][] dp = new int[n+1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, -1, dp);
    }
}

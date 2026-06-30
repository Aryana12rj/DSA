import java.util.*;

class Solution {
    int n;
    int[][] pairs;

    public int solve(int indx, int prev, int[][] dp) {
        if (indx == n) return 0;

        // Memoization check (shift prev by +1 to handle -1 case)
        if (dp[indx][prev+1] != -1) return dp[indx][prev+1];

        // Option 1: skip current pair
        int skip = solve(indx + 1, prev, dp);

        // Option 2: take current pair if valid
        int take = 0;
        if (prev == -1 || pairs[prev][1] < pairs[indx][0]) {
            take = 1 + solve(indx + 1, indx, dp);
        }

        return dp[indx][prev+1] = Math.max(skip, take);
    }

    public int findLongestChain(int[][] pairs) {
        this.n = pairs.length;
        this.pairs = pairs;

        // Sort pairs by first element (or second, both work with recursion)
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, -1, dp);
    }
}


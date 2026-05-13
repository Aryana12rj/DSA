class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] dp = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int mini = Math.min(nums[i], nums[n - 1 - i]);
            int maxi = Math.max(nums[i], nums[n - 1 - i]);
            dp[2] += 2;
            dp[mini + 1] -= 1;
            dp[mini + maxi] -= 1;
            dp[mini + maxi + 1] += 1;
            dp[maxi + limit + 1] += 1;
        }
        int res = n;
        int moves = 0;
        for (int target = 2; target <= 2 * limit; target++) {
            moves += dp[target];
            res = Math.min(res, moves);
        }
        return res;
    }
}
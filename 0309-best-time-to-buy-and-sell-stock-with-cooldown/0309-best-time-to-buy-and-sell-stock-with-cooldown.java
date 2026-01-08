class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return dpp(prices, 0, false, dp);
    }

    public int dpp(int[] nums, int i, boolean buyed, Integer[][] dp) {
        if (i >= nums.length)
            return 0;

        int bi = buyed ? 1 : 0;
        if (dp[i][bi] != null)
            return dp[i][bi];

        int ans;
        if (buyed) {
            int sell = nums[i] + dpp(nums, i + 2, false, dp);
            int hold = dpp(nums, i + 1, true, dp);
            ans = Math.max(sell, hold);
        } else {
            int buy = dpp(nums, i + 1, true, dp) - nums[i];
            int skip = dpp(nums, i + 1, false, dp);
            ans = Math.max(buy, skip);
        }

        dp[i][bi] = ans;
        return ans;
    }
}
class Solution {
    private int tabuFunc(int[] nums, int[][] dp) {
        int n = nums.length;
        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {

                // Not take case
                int notTake = dp[index + 1][prevIndex + 1];

                // Take case
                int take = 0;
                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    take = 1 + dp[index + 1][index + 1];
                }

                dp[index][prevIndex + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        return tabuFunc(nums, dp);
    }
}

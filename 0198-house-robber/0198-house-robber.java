class Solution {
    // max money robbed till index i 
    private int maxRobAt(int index, int[] nums) {
        // TC : O(2^n)
        // base case
        if (index == 0)
            return nums[index];
        if (index < 0)
            return 0;

        // Option 1: rob current house and skip adjacent
        // Option 2: skip current house
        int pick = nums[index] + maxRobAt(index - 2, nums); // why -2 because it is mentioned that we need to pick non-adjacent elements 
        int notPick = maxRobAt(index - 1, nums);

        return Math.max(pick, notPick);
    }

    // memoization
    private int maxRobAtMemo(int index, int[] nums, int[] dp) {
        // TC : O(n)
        // SC : O(n)
        // base case
        if (index == 0)
            return nums[index];
        if (index < 0)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        // Option 1: rob current house and skip adjacent
        // Option 2: skip current house
        int pick = nums[index] + maxRobAtMemo(index - 2, nums, dp); // why -2 because it is mentioned that we need to pick non-adjacent elements 
        int notPick = maxRobAtMemo(index - 1, nums, dp);

        return dp[index] = Math.max(pick, notPick);

    }

    private int robTabu(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int pick = nums[i] + dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }

    private int robSpaceOpt(int[] nums) {

        int n = nums.length;

        if (nums == null || nums.length == 0) return 0;

        if (n == 1)
            return nums[0];
        
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
        
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return robSpaceOpt(nums);
        //return robTabu(nums);
        //return maxRobAt(n - 1, nums, dp);
        //return maxRobAt(n - 1, nums); // max rob at 

    }
}

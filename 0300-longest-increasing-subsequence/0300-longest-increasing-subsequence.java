
// class Solution { //memoization
//     int memo[];
//     public int lengthOfLIS(int[] nums) {
//         memo = new int[nums.length];
//         Arrays.fill(memo , -1);
//         int max = 0 ;
//         for(int i=0 ; i<nums.length ; i++){
//             max = Math.max(max , solve(i,nums));
//         }
//         return max;
//     }

//     public int solve(int i , int nums[]){
//         if(memo[i] != -1) return memo[i];
//         int maxLen = 1; 
//         for(int j=0 ; j<i ; j++){
//             if(nums[i]>nums[j]){
//                 maxLen = Math.max(maxLen , solve(j , nums)+1);
//             }
//         }
//         return memo[i] = maxLen;
//     }
// }




// class Solution { // Brute Force Recursion
//     public int lengthOfLIS(int[] nums) {
//         int max = 0;
 
//         for (int i = 0; i < nums.length; i++) { 
//             max = Math.max(max, solve(i, nums));
//         }
        
//         return max;
//     }

//     public int solve(int i, int[] nums) {
      
//         int maxLen = 1; 

//         for (int j = 0; j < i; j++) {
//             if (nums[i] > nums[j]) {
//                 maxLen = Math.max(maxLen, solve(j, nums) + 1);
//             }
//         }
//         return maxLen;
//     }
// }




// class Solution {   // Tabulation
//     public int lengthOfLIS(int nums[]){
//         if(nums.length == 0 ) return 0;

//         int dp[] = new int [nums.length];

//         Arrays.fill(dp , 1);

//         int maxLen = 1;

//         for(int i=1 ; i<nums.length ; i++){
//             for(int j=0 ; j < i ; j++){
//                 if(nums[i] > nums[j]){
//                     dp[i] = Math.max(dp[i] , dp[j]+1);
//                 }
//             }
//             maxLen = Math.max(maxLen , dp[i]);
//         }

//         return maxLen;
//     }
// }



// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         // 'tails' array stores the smallest tail of all increasing subsequences 
//         // of length i+1 in tails[i].
//         int[] tails = new int[nums.length];
//         int size = 0; // Current length of LIS found

//         for (int x : nums) {
//             // Binary Search to find the first element in 'tails' >= x
//             int i = 0, j = size;
//             while (i != j) {
//                 int m = (i + j) / 2;
//                 if (tails[m] < x) {
//                     i = m + 1;
//                 } else {
//                     j = m;
//                 }
//             }
            
//             // If i == size, it means x is the largest so far -> Append
//             // If i < size, we replace tails[i] with x to make that sequence "better"
//             tails[i] = x;
            
//             if (i == size) {
//                 size++;
//             }
//         }
//         return size;
//     }
// }
// class Solution {

//     // 1. Recursive Solution
//     private int recFunc(int index, int prevIndex, int[] nums) {
        
//         if (index == nums.length)
//             return 0;
//         int notTake = recFunc(index + 1, prevIndex, nums);

//         int take = 0;
//         if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
//             take = 1 + recFunc(index + 1, index, nums);
//         }
//         return Math.max(take, notTake);
//     }
// }

    // 2. Memoization (Top-Down DP)
   class Solution {
    private int memoFunc(int index, int prevIndex, int[] nums, int[][] dp) {
        if (index == nums.length)
            return 0;
        if (dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];

        // Option 1: Skip current element
        int notTake = memoFunc(index + 1, prevIndex, nums, dp);
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + memoFunc(index + 1, index, nums, dp);
        }
        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return memoFunc(0, -1, nums, dp);
    }
}

//     // 3. Tabulation (Bottom-Up DP)
//     private int tabuFunc(int[] nums, int[][] dp) {
        

//         int n = nums.length;

//         for (int index = n - 1; index >= 0; index--) {
//             for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {

//                 // Not take case
//                 int notTake = dp[index + 1][prevIndex + 1];

//                 // Take case
//                 int take = 0;
//                 if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
//                     take = 1 + dp[index + 1][index + 1];
//                 }

//                 dp[index][prevIndex + 1] = Math.max(take, notTake);
//             }
//         }

//         return dp[0][0];
//     }

//     // 4. Space Optimized DP
//     private int spaceOpt(int[] nums, int[] ahead) {
        

//         int n = nums.length;

//         for (int index = n - 1; index >= 0; index--) {
//             int[] curr = new int[n + 1];

//             for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {

//                 int notTake = ahead[prevIndex + 1];

//                 int take = 0;
//                 if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
//                     take = 1 + ahead[index + 1];
//                 }

//                 curr[prevIndex + 1] = Math.max(take, notTake);
//             }

//             ahead = curr;
//         }

//         return ahead[0];
//     }

//     // =======================
//     // 5. Time Optimized DP (Classic LIS)
//     // =======================
//     private int timeOpt(int[] nums, int[] dp) {
//         // dp[i] = length of LIS ending at index i
//         // TC : O(n*n)
//         // SC : O(n)

//         int n = nums.length;
//         int maxi = 1;

//         for (int index = 0; index < n; index++) {
//             for (int prev = 0; prev < index; prev++) {
//                 if (nums[prev] < nums[index]) {
//                     dp[index] = Math.max(dp[index], 1 + dp[prev]);
//                 }
//             }
//             maxi = Math.max(maxi, dp[index]);
//         }

//         return maxi;
//     }

//     public int lengthOfLIS(int[] nums) {

//         int n = nums.length;

//         // DP array for memoization
//         int[][] dp = new int[n][n + 1];
//         for (int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         int[][] dp1 = new int[n + 1][n + 1];
//         int[] ahead = new int[n + 1];

//         // dp[i] = LIS ending at index i
//         int[] timeOptDp = new int[n];
//         Arrays.fill(timeOptDp, 1);

//         // Best practical solution
//         return timeOpt(nums, timeOptDp);

//         // Other approaches (for learning)
//         // return spaceOpt(nums, ahead);
//         // return tabuFunc(nums, dp1);
//         // return memoFunc(0, -1, nums, dp);
//         // return recFunc(0, -1, nums);
//     }
// }
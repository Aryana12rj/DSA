
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




class Solution { // Brute Force Recursion
    public int lengthOfLIS(int[] nums) {
        int max = 0;
 
        for (int i = 0; i < nums.length; i++) { 
            max = Math.max(max, solve(i, nums));
        }
        
        return max;
    }

    public int solve(int i, int[] nums) {
      
        int maxLen = 1; 

        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                maxLen = Math.max(maxLen, solve(j, nums) + 1);
            }
        }
        return maxLen;
    }
}




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
class Solution {
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int prev1 = 0; //bottom up approach
    int prev2 = 0;
    for (int num : nums) {
        int tmp = prev1;
        prev1 = Math.max(prev2 + num, prev1);
        prev2 = tmp;
    }
    return prev1;
    // return rob(nums, nums.length - 1);
}
// private int rob(int[] nums, int i) {
//     if (i < 0) { memoization top down approach
//         return 0;
//     }
//     return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
// }
}


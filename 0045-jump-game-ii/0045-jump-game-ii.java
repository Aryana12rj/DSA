class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int curEnd = 0;   // end of current jump range
        int curFarthest = 0; // farthest we can reach in current range

        for (int i = 0; i < n - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);

            // when we reach the end of current jump range
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}

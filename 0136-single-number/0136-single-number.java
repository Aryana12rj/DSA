class Solution {
    public int singleNumber(int[] nums) {
        int idx=0;
        for(int i=0;i<nums.length;i++){
            idx^=nums[i];
        }
        return idx;
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans=nums.length+1;
        int left=0,sum=0;

        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                ans=Math.min(ans,right-left+1);
                sum-=nums[left++];
            }
        }
        if(ans==nums.length+1)return 0;
        return ans;
    }
}
class Solution {
    public int alternatingSubarray(int[] nums) {
        int n=nums.length;
        int res=-1;
        int dp=-1;

        for(int i=1;i<n;++i,res=Math.max(res,dp)){
            if(dp>0 && nums[i]==nums[i-2]){
                dp++;
            }else{
                dp=nums[i]==nums[i-1]+1?2:-1;
            }
        }
        return res;
    }
}
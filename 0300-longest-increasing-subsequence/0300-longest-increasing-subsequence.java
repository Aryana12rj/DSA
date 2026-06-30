class Solution {
    int n;
    public int lengthOfLIS(int[] nums) {
        n=nums.length;
        int maxlenlis=1;
        int[] dp=new int[n+1];
        Arrays.fill(dp,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxlenlis=Math.max(maxlenlis,dp[i]);
        }
        return maxlenlis;


    }
}
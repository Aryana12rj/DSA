class Solution {
    public boolean solve(int[] nums,int n,int index,int[] dp){
        if(index==n-1){
            return true;
        }
        if(index>=n){
            return false;
        }
        if(dp[index]!=-1){
            return dp[index]==1;
        }
        for(int i=1;i<=nums[index];i++){
            if(solve(nums,n,index+i,dp)==true){
                 dp[index]=1;
                 return true;

            }
        }
        dp[index]=0;
        return false;

    }
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,n,0,dp);
    }
}
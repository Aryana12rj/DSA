class Solution {
    public boolean canPartition(int[] nums) {
        int sum1=0;
        for(int num: nums){
            sum1+=num;
        }
        //sum id odd no partition possible
        if(sum1%2!=0){
            return false;
        }
        int target=sum1/2;
        int n=nums.length;
        int[][] dp=new int[n][target+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,0,target,dp);
    }
    public boolean solve(int[] nums,int indx,int target,int[][] dp){
        if(target==0)return true;
        if(indx>=nums.length)return false;
        if(dp[indx][target]!=-1){
            return dp[indx][target]==1;

        }
        boolean take=false;
        if(nums[indx]<=target){
           take=solve(nums,indx+1,target-nums[indx],dp);
        }
        boolean nottake=solve(nums,indx+1,target,dp);
        dp[indx][target]=(take||nottake)?1:0;
        return dp[indx][target]==1;

    }
}
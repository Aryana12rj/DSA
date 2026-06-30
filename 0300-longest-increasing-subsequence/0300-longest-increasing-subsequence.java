class Solution {
    int n;
    int [] nums;
    public  int solve(int indx,int prev,int[][] dp){
        if(indx>=n){
            return 0;
        }
        if(dp[indx][prev+1]!=-1){
            return dp[indx][prev+1];
        }
        //skip
        int skip=solve(indx+1,prev,dp);
        //take
        int take=0;
        if(prev==-1||nums[prev]<nums[indx]){
            take=1+solve(indx+1,indx,dp);
        }

        return dp[indx][prev+1]=Math.max(take,skip);

    }
    public int lengthOfLIS(int[] nums) {
        this.n=nums.length;
        this.nums=nums;

        int[][] dp=new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,-1,dp);


    }
}
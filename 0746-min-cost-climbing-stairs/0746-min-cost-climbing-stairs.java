class Solution {
    public int solve(int[] cost,int index,int[] dp){
        int n=cost.length;
        if(index>=n){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int step1=cost[index]+solve(cost,index+1,dp);
        int step2=cost[index]+solve(cost,index+2,dp);
        return dp[index]=Math.min(step1,step2);

    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);

        return Math.min(solve(cost,0,dp),solve(cost,1,dp));

    }
}
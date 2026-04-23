class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=coins[i-1];j<=amount;j++){
                if(dp[j-coins[i-1]]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-coins[i-1]]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE ? -1:dp[amount];
    }
}
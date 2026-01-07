class Solution {
    public int f(int[] prices, int n, int idx, int buy, int cnt, Integer[][][] dp) {
        if(idx == n) return 0;
        if(cnt == 0) return 0;
        if(dp[buy][cnt][idx] != null) return dp[buy][cnt][idx]; 

        int profit = 0;

        if(buy == 1) {
            int take = -prices[idx] + f(prices, n, idx+1, 0, cnt, dp);
            int notTake = 0 + f(prices, n, idx+1, 1, cnt, dp);

            profit = Math.max(take, notTake);
        }
        else {
            int sell = prices[idx] + f(prices, n, idx+1, 1, cnt-1, dp);
            int dontSell = 0 + f(prices, n, idx+1, 0, cnt, dp);

            profit = Math.max(sell, dontSell);
        }

        return dp[buy][cnt][idx] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cnt = 2;
        Integer[][][] dp = new Integer[2][cnt+1][n];

        return f(prices, n, 0, 1, cnt, dp);
    }
}
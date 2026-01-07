import java.util.*;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][buy] where buy = 1 means we can buy, buy = 0 means we can sell
        int[][] dp = new int[n][2];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return dpMem(0, 1, prices, dp); 
    }
    
    private int dpMem(int i, int buy, int[] prices, int[][] dp) {
        int n = prices.length;
        if (i == n) return 0;  
        
        if (dp[i][buy] != -1) return dp[i][buy]; 
        
        int profit;
        if (buy == 1) {
            // Can buy: choose between buying today or skipping
            profit = Math.max(-prices[i] + dpMem(i + 1, 0, prices, dp),
                               dpMem(i + 1, 1, prices, dp));
        } else {
            // Can sell: choose between selling today or skipping
            profit = Math.max(prices[i] + dpMem(i + 1, 1, prices, dp),
                               dpMem(i + 1, 0, prices, dp));
        }
        
        return dp[i][buy] = profit;
    }
}

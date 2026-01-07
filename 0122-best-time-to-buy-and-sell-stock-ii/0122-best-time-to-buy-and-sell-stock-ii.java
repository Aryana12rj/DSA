public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] next = new int[2]; 
        int[] curr = new int[2];  

        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (canBuy == 1) {
                    curr[canBuy] = Math.max(-prices[i] + next[0], next[1]);
                } else {
                    curr[canBuy] = Math.max(prices[i] + next[1], next[0]);
                }
            }
            next[0] = curr[0];
            next[1] = curr[1];
        }

        return next[1];
    }
}




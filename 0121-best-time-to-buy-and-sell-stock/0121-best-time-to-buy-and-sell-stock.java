class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0;
        int n=prices.length;
        for(int i=0;i<n;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            profit=Math.max(profit,prices[i]-min);
        }
        return profit;
    }
}
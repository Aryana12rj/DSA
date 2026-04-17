class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        if(amount==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        return coinchnage(coins,n,amount);

    }
    public int coinchnage(int[] coins,int n,int amount){
        if(n==0){
            return 0;

        }
        if(amount==0){
            return 1;
        }
        if(coins[n-1]>amount){
            return coinchnage(coins,n-1,amount);

        }
        return coinchnage(coins,n,amount-coins[n-1])+coinchnage(coins,n-1,amount);
    }
}
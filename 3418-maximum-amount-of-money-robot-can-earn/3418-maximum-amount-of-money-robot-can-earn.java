class Solution {
    public int maximumAmount(int[][] coins) {
        int n= coins.length;
        int m=coins[0].length;
        int[][][]dp= new int[n][m][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        return f(0,0,0,n,m,coins,dp);
    }
    static int f(int i,int j,int k,int n,int m,int[][]coins,int[][][]dp){
        if(i==n-1 && j==m-1){
            if(coins[i][j]<0 && k<2) return 0;
            return coins[i][j];
        }
        if(dp[i][j][k]!=Integer.MIN_VALUE) return dp[i][j][k];
        int r=Integer.MIN_VALUE;
        int d=Integer.MIN_VALUE;
        int ans= Integer.MIN_VALUE;
        if(j+1<m){
            if(coins[i][j]>0){
                r= Math.max(r,coins[i][j]+f(i,j+1,k,n,m,coins,dp));
            }
            else{
                r= Math.max(r,coins[i][j]+ f(i,j+1,k,n,m,coins,dp));
                if(k<2){
                    r= Math.max(r,f(i,j+1,k+1,n,m,coins,dp));
                }
            }
        }
        if(i+1<n){
            if(coins[i][j]>0){
                d= Math.max(d,coins[i][j]+f(i+1,j,k,n,m,coins,dp));
            }
            else{
                d= Math.max(d,coins[i][j]+ f(i+1,j,k,n,m,coins,dp));
                if(k<2){
                    d= Math.max(d,f(i+1,j,k+1,n,m,coins,dp));
                }
            }
        }
        ans= Math.max(r,d);
        dp[i][j][k]= ans;
        return ans;
    }
}
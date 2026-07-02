class Solution {
    public int solve(int i,int j,int m,int n,int[][] dp){
        if(i==m-1 && j==n-1){
            return 1;

        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i<0||i>=m||j<0||j>=n){
            return 0;
        }
        int down=solve(i+1,j,m,n,dp);
        int right=solve(i,j+1,m,n,dp);
        return dp[i][j]=down+right;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,m,n,dp);
    }
}
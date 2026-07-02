class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=1;//total ways to reach from (0,0) to (0,0) is 0 but her its is said to be one path that it 
        //fill oth row
        for(int col=1;col<n;col++){
            dp[0][col]=1;
        }
        //fill 0th col
        for(int row=1;row<m;row++){
            dp[row][0]=1;
        }
        //for remainiing 2d array we fill the dp table
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        //answer
        return dp[m-1][n-1];
    }
}
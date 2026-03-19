class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] prefix=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                prefix[i][j]=grid[i-1][j-1]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
            }
    }
    int count=0;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(prefix[i][j]<=k){
                count++;
            }
        }
    }
    return count;

        

        
    }
}
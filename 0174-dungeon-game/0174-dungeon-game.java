class Solution {
    int m,n;
    int[][] memo;
    public int calculateMinimumHP(int[][] dungeon) {
         m=dungeon.length;
         n=dungeon[0].length;
        memo=new int[m][n];
        return addorfrop(0,0,dungeon);
    }
    public int addorfrop(int i,int j,int[][] dungeon){
        if(i>=m||j>=n){
            return Integer.MAX_VALUE;

        }
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        if(i==m-1 && j==n-1){
            return memo[i][j]=Math.max(1,1-dungeon[i][j]);
        }
        int right=addorfrop(i,j+1,dungeon);
        int down=addorfrop(i+1,j,dungeon);
        int minnext=Math.min(right,down);
        memo[i][j]=Math.max(1,minnext-dungeon[i][j]);
        return memo[i][j];
    }
}
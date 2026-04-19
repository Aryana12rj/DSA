class Solution {
    public void dfs(char[][] grid,int i,int j,boolean[][] visited){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||visited[i][j]||grid[i][j]!='1'){
            return;
        }
        visited[i][j]=true;
        dfs(grid,i-1,j,visited);
        dfs(grid,i+1,j,visited);
        dfs(grid,i,j+1,visited);
        dfs(grid,i,j-1,visited);
    }
    public int numIslands(char[][] grid) {
        int islands=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&& !visited[i][j]){
                    dfs(grid,i,j,visited);
                    islands++;
                }
            }
        }
        return islands;
    }
}
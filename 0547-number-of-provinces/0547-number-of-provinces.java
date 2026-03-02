class Solution {
    private void dfs(int node,int[][] isConnected,boolean[] vis,int n){
        vis[node]=true;
        for(int i=0;i<n;i++){
            if(isConnected[node][i]==1&&!vis[i]){
                dfs(i,isConnected,vis,n);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] vis=new boolean[n];
        int provinces=0;//for count of provinces

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,isConnected,vis,n);
                provinces++;
            }
        }
        return provinces;
    }
}
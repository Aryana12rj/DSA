
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m=graph.length;
        boolean v[]=new boolean[m];
        boolean path[]=new boolean[m];
        boolean[] check=new boolean[m];
        for(int i=0;i<m;i++){
            if(!v[i]){
                dfs(i,graph,v,path,check);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            if(check[i]){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean dfs(int i,int[][] grid,boolean[] v,boolean[] path,boolean[] check){
        v[i]=true;path[i]=true;check[i]=false;
        for(int j=0;j<grid[i].length;j++){
            int next=grid[i][j];
            if(!v[next]){
                if(dfs(next,grid,v,path,check)){
                    return true;
                }
            }
            else if(path[next]){
                return true;
            }
        }
        check[i]=true;
        path[i]=false;
        return false;
    }
}
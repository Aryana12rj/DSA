class Solution {
    static final long MOD=1_000_000_007;
    //Dfs to compute max depth of the tree
    public int getmaxdepth(Map<Integer,List<Integer>> adj,int node,int parent){
        int depth=0;
        if(!adj.containsKey(node))return 0;//leaf 

        for(int neigh:adj.get(node)){
            if(neigh==parent)continue;
            depth=Math.max(depth,1+getmaxdepth(adj,neigh,node));
        }
        return depth;
    }
    public long power(long base,long exponent){
        long res=1;
        base=base%MOD;
        while(exponent>0){
            if((exponent&1)==1)res=(res*base)%MOD;
            base=(base*base)%MOD;
            exponent >>=1;
        }
        return res;

    }

    public int assignEdgeWeights(int[][] edges) {

        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            adj.computeIfAbsent(u,k -> new ArrayList<>()).add(v);

            adj.computeIfAbsent(v,k -> new ArrayList<>()).add(u);
        }
        int d=getmaxdepth(adj,1,-1);

        return (int) power(2,d-1);

    }
}
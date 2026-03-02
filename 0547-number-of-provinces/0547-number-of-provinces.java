class DSU{
    int[] parent,size;
    DSU(int n){
        parent=new int[n];
        size=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;

        }
    }
    public  int findparent(int x){
        if(parent[x]==x)return x;
        return parent[x]=findparent(parent[x]);
    }
    public void unionbysize(int u,int v){
        int pu=findparent(u);
        int pv=findparent(v);
        if(pu==pv)return ;
        if(size[u]<size[v]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }else{
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
    }

}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DSU dsu=new DSU(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    dsu.unionbysize(i,j);
                }

            }
        }
        int provinces=0;
        for(int i=0;i<n;i++){
            if(dsu.findparent(i)==i)provinces++;
        }

        return provinces;
    }
}
class Solution{
    int n;
    int[] segmin,segmax,lazy;
    Map<Integer,Integer> map;
    public int longestBalanced(int[] nums){
        n=nums.length;
        segmin=new int[4*n];
        segmax=new int[4*n];
        lazy=new int[4*n];
        map=new HashMap<>();

        int maxlen=0;
        for(int r=0;r<n;r++){
            int val=nums[r]%2==0 ? 1:-1;
        
        int previndx=map.getOrDefault(nums[r],-1);
        if(previndx !=-1){
            updaterange(0,previndx,0,0,n-1,-val);
        }
        updaterange(0,r,0,0,n-1,val);

        int LeftMostZero=findleftmostzero(0,0,n-1);
        if(LeftMostZero !=-1){
            maxlen=Math.max(maxlen,r-LeftMostZero+1);
        }
        map.put(nums[r],r);
        }
        return maxlen;
    }
    public int findleftmostzero(int i,int l ,int r){
        lazypropagate(i,l,r);
        if(segmin[i]>0 || segmax[i]<0)return -1;
        if(l==r){
            return l;
        }
        int mid=l+(r-l)/2;
        int left=findleftmostzero(2*i+1,l,mid);
        if(left!=-1)return left;

        return findleftmostzero(2*i+2,mid+1,r);
    }
    public void updaterange(int start,int end,int i,int l,int r,int val){
        lazypropagate(i,l,r);
        if(l>end || r<start)return ;
        if(l>=start && r<=end){
            lazy[i]+=val;
            lazypropagate(i,l,r);
            return;
        }
        int mid=l+(r-l)/2;
        updaterange(start,end,2*i+1,l,mid,val);
        updaterange(start,end,2*i+2,mid+1,r,val);

        segmin[i]=Math.min(segmin[2*i+1],segmin[2*i+2]);
        segmax[i]=Math.max(segmax[2*i+1],segmax[2*i+2]);
    }
    public void lazypropagate(int i,int l,int r){
        if(lazy[i]!=0){
            segmin[i]+=lazy[i];
            segmax[i]+=lazy[i];
        }
        if(l!=r){
            lazy[2*i+1]+=lazy[i];
            lazy[2*i+2]+=lazy[i];
        }
        lazy[i]=0;
        }
}

    


class Solution {
    public int longestBalanced(int[] nums) {
        int n=nums.length;

        int[] balance=new int[n];//first occurrnce markers for current l
        HashMap<Integer,Integer> first=new HashMap<>();//val -> first occurrence index
        int res=0;
        for(int l=n-1;l>=0;l--){
            int x=nums[l];
        //if x already presents a first occurrence to the right,remove the old marker
        Integer oldpos=first.get(x);
        if(oldpos!=null)
            balance[oldpos]=0;
            
        
        //Now x becomes first ocurrnce at l
        first.put(x,l);
        balance[l]=((x&1)==0)?1:-1;

        //find rightmost r>=l such that sum(balance[l..r])==0
        int s=0;
        for(int r=l;r<n;r++){
            s+=balance[r];
            if(s==0){
                res=Math.max(res,r-l+1);
            }
        }
        }
        return res;

    }
}
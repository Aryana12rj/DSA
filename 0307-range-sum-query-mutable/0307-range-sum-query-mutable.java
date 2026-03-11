class NumArray {
    int[] tree;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        n=nums.length;
        this.nums=nums;
        tree=new int[n+1];

        for(int i=0;i<n;i++){
            updatetree(i+1,nums[i]);
        }
    }
    private void updatetree(int i,int val){

        while(i<=n ){
            tree[i] +=val;
            i+=i & (-i);
        }
    }
    public int prefixsum(int i){
        int sum=0;
        while(i>0){
            sum+=tree[i];
            i-=i&(-i);
        }
        return sum;
    }

    
    public void update(int index, int val) {
        int diff=val-nums[index];
        nums[index]=val;
        updatetree(index+1,diff);
    }
    
    public int sumRange(int left, int right) {
        return prefixsum(right+1)-prefixsum(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
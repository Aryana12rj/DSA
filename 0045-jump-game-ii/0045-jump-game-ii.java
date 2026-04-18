class Solution {
    public int jump(int[] nums) {
        int minjumps=0;
        //what level of array is used for BFS
        int left=0;
        int right=0;
        while(right<nums.length-1){
            int farthest=0;
            for(int i=left;i<right+1;i++){
                farthest=Math.max(farthest,i+nums[i]);
            }
            left=right+1;
            right=farthest;
            minjumps+=1;
        }
        return minjumps;
    }
}
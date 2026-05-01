class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int maxcount=0;
        int currcount=0;
        for(int j=0;j<n;j++){
            if(nums[j]==1){
                currcount++;
            }else{
                maxcount=Math.max(maxcount,currcount);
                currcount=0;
            }
        }
        return maxcount=Math.max(maxcount,currcount);
    }
}
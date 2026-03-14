class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int j=0;
        int maxlen=0;

        for(int i=0;i<nums.length;i++){
            while(nums[i]-nums[j]>1){
                j++;
            }
            if(nums[i]-nums[j]==1){
                maxlen=Math.max(maxlen,i-j+1);
            }
        }
        return maxlen;
    }
}
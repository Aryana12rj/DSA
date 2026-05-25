class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int i=0;
        for(int n:nums){
            if(i<k||n!=nums[i-k]){
                nums[i++]=n;
            }
        }
        return Arrays.copyOf(nums,i);
    }
}
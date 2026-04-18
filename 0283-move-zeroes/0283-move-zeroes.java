class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                swap(nums,i,j);
                i++;
            }
        }
    }
    public void swap(int[] nums,int i,int j){
        nums[i]=(nums[i]+nums[j])-(nums[j]=nums[i]);
    }
}
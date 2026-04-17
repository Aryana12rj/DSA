class Solution {
    public int majorityElement(int[] nums) {
        int count=1;
        int majorityele=nums[0];//assume
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(count==0){
                majorityele=nums[i];
                count=1;
            }else if(nums[i]==majorityele){
                count++;
            }else{
                count--;
            }
        }
        return majorityele;
    }
}
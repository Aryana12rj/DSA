class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int countbreaks=0;

        for(int i=0;i<n;i++){
            int next=nums[(i+1)%n];
            if(nums[i]>next){
                countbreaks++;
            }
        }
        return countbreaks<=1;

    }
}
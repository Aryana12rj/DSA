class Solution {
    public void reversearr(int[] nums,int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int pivot=-1;
    //finding pivot (first decreasing element from ythe right)
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }
        //if no pivot exist reverse the entire array
        if(pivot==-1){
            reversearr(nums,0);
            return;
        }
        //find next greater
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[pivot]){
                int temp=nums[i];
                nums[i]=nums[pivot];
                nums[pivot]=temp;
                break;
            }
        }
        reversearr(nums,pivot+1);
    }
}
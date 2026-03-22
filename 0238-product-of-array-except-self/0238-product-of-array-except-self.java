class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] answer=new int[n];
        answer[0]=1;
        for(int i=1;i<n;i++){
            answer[i]=answer[i-1]*nums[i-1];
        }
        int maxprod=1;
        for(int r=n-1;r>=0;r--){
            answer[r]=answer[r]*maxprod;
            maxprod*=nums[r];
        }
        return answer;
    }
}
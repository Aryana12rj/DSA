class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] memo=new int[n];
        Arrays.fill(memo,-1);
        return solve(nums,0,n,memo);
    }
    public int solve(int[] nums,int indx,int n,int[] memo){
        if(indx>=n){
            return 0;

        }
        if(memo[indx]!=-1){
            return memo[indx];
        }
        int steal=nums[indx]+solve(nums,indx+2,n,memo);
        int skip=solve(nums,indx+1,n,memo);
        memo[indx]= Math.max(steal,skip);
        return memo[indx];
    }
}
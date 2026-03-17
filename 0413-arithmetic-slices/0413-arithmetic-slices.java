class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if(n<=2){
            return 0;
        }
        int prev=nums[1]-nums[0];
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            int diff=nums[i]-nums[i-1];
            if(diff==prev){
                dp[i]=dp[i - 1]+1;
            }else{
                dp[i]=2;
                prev=diff;
            }

        }
        int res=0;
        for(int i=0;i<n;i++){
            if(dp[i]>=3){
                res+=dp[i]-2;
            }
            System.out.println(dp[i]);
        }
        return res;
    }
}
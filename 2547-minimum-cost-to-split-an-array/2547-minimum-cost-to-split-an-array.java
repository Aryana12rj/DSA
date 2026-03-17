class Solution {
    public int minCost(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return memodp(0,nums,dp,k);


    }
    private int memodp(int i,int[] nums,int[] dp,int k){
        if(i==nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        Map<Integer,Integer> mp=new HashMap<>();
        int uniquecount=0;
        int localans=Integer.MAX_VALUE;
        for(int j=i;j<nums.length;j++){
            int val=nums[j];
            int valfreq=mp.getOrDefault(val,0);
            if(valfreq==0)uniquecount++;
            if(valfreq==1)uniquecount--;
            mp.put(val,valfreq+1);
            localans=Math.min(localans,memodp(j+1,nums,dp,k)+(j-i+1-uniquecount)+k);
        }
        return dp[i]=localans;
    }

}
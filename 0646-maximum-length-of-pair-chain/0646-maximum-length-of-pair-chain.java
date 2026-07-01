class Solution {

    public int findLongestChain(int[][] pairs) {
        int n=pairs.length;
        //sort by first element
        Arrays.sort(pairs,(a,b) -> a[0]-b[0]);
        int maxlenlis=1;
        int[] dp=new int[n+1];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxlenlis=Math.max(maxlenlis,dp[i]);

        }
        return maxlenlis;
    }
}
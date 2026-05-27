class Solution {
    public int dfs(int[] arr,int d,int[] dp,int i){
        if(dp[i]!=0){
            return dp[i];
        }
        int max1=1;
        int n=arr.length;
        for(int j=1;j<=d && i+j<n;j++){
            if(arr[i]>arr[i+j]){
                max1=Math.max(max1,1+dfs(arr,d,dp,i+j));
            }else {
                break;
            }
        }
        for(int j=1;j<=d && i-j>=0;j++){
            if(arr[i]>arr[i-j]){
                max1=Math.max(max1,1+dfs(arr,d,dp,i-j));
            }else{
                break;
            }
        }
        return dp[i]=max1;
    }
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int[] dp=new int[n];

        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,dfs(arr,d,dp,i));
        }
        return ans;
    }
}
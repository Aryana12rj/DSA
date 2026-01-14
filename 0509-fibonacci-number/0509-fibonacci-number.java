// class Solution{
//     public int fib(int n){
//         if(n<=1){//recursion
//             return n;
//         }else{
//             return fib(n-1)+fib(n-2);
//         }
//     }
// }
class Solution{
    public int f(int[] dp,int n){
        if(n<=1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n]=f(dp,n-1)+f(dp,n-2);
        return dp[n];
    }
    public int fib(int n){
    
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        return f(dp,n);
    }
}
// class Solution {//Tabulation (Bottom up Approach)
//     public int fib(int n) {
//         if(n<=1) return n;
//         int dp[] = new int[n + 1];

//         dp[0] = 0;
//         dp[1] = 1;

//         for (int i = 2; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }

//         return dp[n];
//     }
// }
// class Solution{              //space optimization
//     int p1=0,p2=1;
//     public int fib(int n){
//         if(n<=1){
//             return n;
//         }
//         for(int i=2;i<n+1;i++){
//             int temp=p1+p2;
//             p1=p2;
//             p2=temp;
//         }
//         return p2;

//     }
// }
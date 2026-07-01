import java.util.*;

class Solution {
    int n;

    //  Check if 'prev' is a predecessor of 'curr'
    public boolean isPredecessor(String prev, String curr) {
        int M = prev.length();
        int N = curr.length();

        // predecessor must be exactly one shorter
        if (M + 1 != N) return false;

        int i = 0, j = 0;
        while (i < M && j < N) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == M; // all chars of prev matched
    }

    public int longestStrChain(String[] words) {
        n = words.length;
        // sort words by length 
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int[] dp = new int[n+1]; 
        Arrays.fill(dp,1);
        int maxlenlis=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(isPredecessor(words[j],words[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxlenlis=Math.max(maxlenlis,dp[i]);
        }
        return maxlenlis;


    }
}

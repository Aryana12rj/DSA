import java.util.*;

class Solution {
    int n;
    Integer[][] memo; 

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

    //  Recursive LIS variant with memoization
    public int Lis(int currIndx, int prevIndx, String[] words) {
        if (currIndx == n) return 0;

        if (memo[currIndx][prevIndx + 1] != null) {
            return memo[currIndx][prevIndx + 1];
        }

        // take or skip
        int take = 0;
        if (prevIndx == -1 || isPredecessor(words[prevIndx], words[currIndx])) {
            take = 1 + Lis(currIndx + 1, currIndx, words);
        }

        int skip = Lis(currIndx + 1, prevIndx, words);

        return memo[currIndx][prevIndx + 1] = Math.max(take, skip);
    }

    public int longestStrChain(String[] words) {
        n = words.length;

        // sort words by length (important for LIS transitions)
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        memo = new Integer[n][n + 1]; // prevIndx can be -1 → shift by +1

        return Lis(0, -1, words);
    }
}

import java.util.*;

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxChain = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (Predecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxChain = Math.max(maxChain, dp[i]);
        }

        return maxChain;
    }
    private boolean Predecessor(String s1, String s2) {
    if (s2.length() != s1.length() + 1) return false;

    int i = 0, j = 0;
    while (i < s1.length() && j < s2.length()) {
        if (s1.charAt(i) == s2.charAt(j)) {
            i++;
            j++;
        } else {
            j++; 
        }
    }
    return i == s1.length();
}

}

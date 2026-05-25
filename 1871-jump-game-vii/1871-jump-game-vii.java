import java.util.*;

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') return false;

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachableCount = 0; // sliding window count

        for (int i = 1; i < n; i++) {
            // Expand window: add dp[i - minJump] if valid
            if (i - minJump >= 0 && dp[i - minJump]) {
                reachableCount++;
            }

            // Shrink window: remove dp[i - maxJump - 1] if valid
            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                reachableCount--;
            }

            // Mark reachable if window has at least one true and s[i] == '0'
            dp[i] = (reachableCount > 0 && s.charAt(i) == '0');
        }

        return dp[n - 1];
    }
}


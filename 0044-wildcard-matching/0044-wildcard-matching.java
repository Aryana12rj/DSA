class Solution {
    public boolean isMatch(String s, String p) {
        // dp[i][j] stores result of matching s[i:] with p[j:]
        Integer[][] dp = new Integer[s.length()][p.length()];
        return fun(0, 0, s, p, dp);
    }

    private boolean fun(int idx1, int idx2, String s, String p, Integer[][] dp) {
        // If pattern is fully traversed
        if (idx2 == p.length()) {
            return idx1 == s.length();
        }

        // If string is fully traversed
        if (idx1 == s.length()) {
            for (int k = idx2; k < p.length(); k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        // Memoization check
        if (dp[idx1][idx2] != null) {
            return dp[idx1][idx2] == 1;
        }

        boolean ans;
        char sc = s.charAt(idx1);
        char pc = p.charAt(idx2);

        if (sc == pc || pc == '?') {
            ans = fun(idx1 + 1, idx2 + 1, s, p, dp);
        } else if (pc == '*') {
            ans = fun(idx1, idx2 + 1, s, p, dp) || fun(idx1 + 1, idx2, s, p, dp);
        } else {
            ans = false;
        }

        dp[idx1][idx2] = ans ? 1 : 0;
        return ans;
    }
}

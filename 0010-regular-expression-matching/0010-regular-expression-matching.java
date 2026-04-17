class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    private boolean solve(String s, String p, int i, int j) {
        // If pattern is finished, string must also be finished
        if (j == p.length()) {
            return i == s.length();
        }

        // First character match check
        boolean firstMatch = (i < s.length() &&
                             (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        // Handle '*' (look ahead one character in pattern)
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Case 1: skip "x*" entirely
            // Case 2: use "x*" if firstMatch
            return solve(s, p, i, j + 2) ||
                   (firstMatch && solve(s, p, i + 1, j));
        } else {
            // Normal case: move both forward if match
            return firstMatch && solve(s, p, i + 1, j + 1);
        }
    }
}

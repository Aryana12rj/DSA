class Solution {
    public int minCost(int n, int[] cuts) {
        var c = new ArrayList<Integer>();
        for (int cut : cuts) {
            c.add(cut);
        }
        c.add(0);
        c.add(n);
        Collections.sort(c);

        int m = c.size();
        int[][] dp = new int[m][m];

        for (int len = 2; len < m; ++len) {
            for (int i = 0; i + len < m; ++i) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j],
                        c.get(j) - c.get(i) + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][m - 1];
    }
}

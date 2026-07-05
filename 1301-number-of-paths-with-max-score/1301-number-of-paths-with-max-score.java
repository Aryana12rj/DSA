class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int MOD = 1_000_000_007;
        int n = board.size();

        int[][] dp = new int[n][n];
        int[][] ways = new int[n][n];

        for (int[] row : dp) Arrays.fill(row, -1);

        dp[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char c = board.get(i).charAt(j);

                if (c == 'X' || (i == n - 1 && j == n - 1))
                    continue;

                int best = -1;
                long cnt = 0;

                int[][] dir = {{1,0},{0,1},{1,1}};

                for (int[] d : dir) {
                    int x = i + d[0], y = j + d[1];

                    if (x >= n || y >= n || dp[x][y] == -1)
                        continue;

                    if (dp[x][y] > best) {
                        best = dp[x][y];
                        cnt = ways[x][y];
                    } else if (dp[x][y] == best) {
                        cnt = (cnt + ways[x][y]) % MOD;
                    }
                }

                if (best == -1) continue;

                int val = Character.isDigit(c) ? c - '0' : 0;

                dp[i][j] = best + val;
                ways[i][j] = (int)(cnt % MOD);
            }
        }

        if (dp[0][0] == -1) return new int[]{0,0};
        return new int[]{dp[0][0], ways[0][0]};
    }
}

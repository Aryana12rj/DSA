import java.util.*;

class Solution {
    private int n;
    private final int MOD = 1_000_000_007;
    private List<String> board;
    private Pair[][] memo; // cache; Pair(score, ways)

    // Helper class to store (score, ways)
    static class Pair {
        int score, ways;
        Pair(int s, int w) {
            this.score = s;
            this.ways = w;
        }
    }

    private Pair solve(int i, int j) {
        // Out of bounds
        if (i < 0 || j < 0) return new Pair(-1, 0);
        // Blocked cell
        if (board.get(i).charAt(j) == 'X') return new Pair(-1, 0);
        // Start cell
        if (i == 0 && j == 0) return new Pair(0, 1);

        // Already computed
        if (memo[i][j] != null) return memo[i][j];

        int val = (board.get(i).charAt(j) == 'S') ? 0 : board.get(i).charAt(j) - '0';

        Pair up   = solve(i - 1, j);
        Pair left = solve(i, j - 1);
        Pair diag = solve(i - 1, j - 1);

        int best = Math.max(up.score, Math.max(left.score, diag.score));
        if (best == -1) {
            memo[i][j] = new Pair(-1, 0);
            return memo[i][j];
        }

        long ways = 0;
        if (up.score == best)   ways = (ways + up.ways) % MOD;
        if (left.score == best) ways = (ways + left.ways) % MOD;
        if (diag.score == best) ways = (ways + diag.ways) % MOD;

        memo[i][j] = new Pair(best + val, (int) ways);
        return memo[i][j];
    }

    public int[] pathsWithMaxScore(List<String> board) {
        this.board = board;
        n = board.size();
        memo = new Pair[n][n];

        Pair res = solve(n - 1, n - 1);
        if (res.score == -1) return new int[]{0, 0};
        return new int[]{res.score, res.ways};
    }
}

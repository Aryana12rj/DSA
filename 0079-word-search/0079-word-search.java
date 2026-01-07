class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int L = word.length();
        if (L > m * n) return false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (solve(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) return true;
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        if (board[i][j] != word.charAt(idx)) return false;

        char tmp = board[i][j];
        board[i][j] = '#'; 

        boolean found = solve(board, word, i + 1, j, idx + 1) ||
                        solve(board, word, i - 1, j, idx + 1) ||
                        solve(board, word, i, j + 1, idx + 1) ||
                        solve(board, word, i, j - 1, idx + 1);

        board[i][j] = tmp; 
        return found;
    }
}
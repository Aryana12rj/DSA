class Solution {
    List<List<String>> ans;
    boolean[] col, diag1, diag2;

    private void nQueens(int row, int n, char[][] board) {
        // Base case: placed queens in all n rows
        if (row == n) {
            List<String> res = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                res.add(new String(board[i]));  // Convert char[] to String
            }
            ans.add(res);
            return;
        }
        
        // Try placing queen in each column of current row
        for (int c = 0; c < n; c++) {
            // Calculate diagonal indices
            int d1 = row - c + n - 1;  // Left diagonal (↘): offset to make positive
            int d2 = row + c;          // Right diagonal (↙): naturally positive
            
            // O(1) conflict check - skip if any constraint violated
            if (col[c] || diag1[d1] || diag2[d2]) 
                continue;
            
            // Place queen and mark conflicts
            board[row][c] = 'Q';
            col[c] = diag1[d1] = diag2[d2] = true;
            
            // Explore next row
            nQueens(row + 1, n, board);
            
            // Backtrack: remove queen and unmark conflicts
            board[row][c] = '.';
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        col = new boolean[n];           // Track occupied columns
        diag1 = new boolean[2 * n - 1]; // Track occupied ↘ diagonals
        diag2 = new boolean[2 * n - 1]; // Track occupied ↙ diagonals
        
        // Initialize board with all empty cells
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        nQueens(0, n, board);
        return ans;
    }
}
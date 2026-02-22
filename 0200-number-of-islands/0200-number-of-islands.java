class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    check(grid, i, j, m, n);
                }
            }
        }
        return islands;
    }

    private static void check(char mat[][], int i, int j, int m, int n){
        mat[i][j] = '0';

        // left
        if(j - 1 >= 0 && mat[i][j - 1] == '1'){
            check(mat, i, j - 1, m, n);
        }

        // right
        if(j + 1 < n && mat[i][j + 1] == '1'){
            check(mat, i, j + 1, m, n);
        }

        // up
        if(i - 1 >= 0 && mat[i - 1][j] == '1'){
            check(mat, i - 1, j, m, n);
        }

        // down
        if(i + 1 < m && mat[i + 1][j] == '1'){
            check(mat, i + 1, j, m, n);
        }
    }
}
class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = cells.length;
        int lastValidDay = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canWalk(row, col, cells, mid)) {
                lastValidDay = mid; // This day works, try to find a later one
                left = mid + 1;
            } else {
                right = mid - 1; // Too much water, try an earlier day
            }
        }
        return lastValidDay;
    }

    private boolean canWalk(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        // Start BFS from every land cell in the top row
        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0) {
                queue.offer(new int[] { 0, c });
                visited[0][c] = true;
            }
        }

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == row - 1)
                return true; // Reached the bottom row!

            for (int[] d : directions) {
                int nr = curr[0] + d[0], nc = curr[1] + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col
                        && grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }
        return false;
    }
}
import java.util.*;

class Solution {

    // Directions: up, down, left, right
    private static final int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    // Helper function: check if we can reach (n-1,n-1) with safeness >= limit
    private boolean canReach(int[][] dist, int limit) {
        int n = dist.length;

        // If starting cell itself is unsafe, return false
        if (dist[0][0] < limit) return false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            // Destination reached
            if (r == n-1 && c == n-1) return true;

            // Explore neighbors
            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    !vis[nr][nc] &&
                    dist[nr][nc] >= limit) {

                    vis[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][n];

        // Initialize distance matrix with large values
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        // Multi-source BFS: start from all thief cells (grid[i][j] == 1)
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        // BFS to compute minimum distance from each cell to nearest thief
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    dist[nr][nc] == Integer.MAX_VALUE) {

                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        // Binary search on safeness factor
        int low = 0, high = 2*n, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(dist, mid)) {
                ans = mid;      // mid is possible, try higher
                low = mid + 1;
            } else {
                high = mid - 1; // mid not possible, try lower
            }
        }
        return ans;
    }
}

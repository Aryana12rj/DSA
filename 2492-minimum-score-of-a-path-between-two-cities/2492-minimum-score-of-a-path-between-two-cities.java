import java.util.*;

class Solution {
    // 🔹 DFS function to traverse the graph
    private void dfs(List<List<int[]>> adj, int u, boolean[] visited, int[] minLen) {
        visited[u] = true; // mark current node as visited

        for (int[] edge : adj.get(u)) {
            int v = edge[0];   // neighbor city
            int d = edge[1];   // road distance (weight)

            // update minimum edge weight seen so far
            minLen[0] = Math.min(minLen[0], d);

            // continue DFS if neighbor not visited
            if (!visited[v]) {
                dfs(adj, v, visited, minLen);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        // 🔹 Step 1: Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        // 🔹 Step 2: DFS from city 1
        boolean[] visited = new boolean[n + 1];
        int[] minLen = {Integer.MAX_VALUE}; // use array to allow modification inside DFS

        dfs(adj, 1, visited, minLen);

        // 🔹 Step 3: Return minimum edge weight found
        return minLen[0];
    }
}

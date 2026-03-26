import java.io.*;
import java.util.*;

public class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // Build adjacency list for the original nodes
        // Weight of edge (u, v) is cnt + 1
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
            adj[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        // Dijkstra's to find min distance to all original nodes
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue;

            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int weight = neighbor[1] + 1;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        int totalReachable = 0;
        // Count original nodes that are reachable
        for (int i = 0; i < n; i++) {
            if (dist[i] <= maxMoves) {
                totalReachable++;
            }
        }

        // Count subdivision nodes on each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];

            // Nodes reachable from u side
            int a = dist[u] <= maxMoves ? Math.min(cnt, maxMoves - dist[u]) : 0;
            // Nodes reachable from v side
            int b = dist[v] <= maxMoves ? Math.min(cnt, maxMoves - dist[v]) : 0;

            // Total is a + b, but cannot exceed the number of subdivision nodes (cnt)
            totalReachable += Math.min(cnt, a + b);
        }

        return totalReachable;
    }
}
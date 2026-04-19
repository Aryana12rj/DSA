class Solution {
    public boolean isCycleDFS(int src, boolean[] visited, boolean[] recpath, List<List<Integer>> adj) {
        visited[src] = true;
        recpath[src] = true;

        for (int v : adj.get(src)) {
            if (!visited[v]) {
                if (isCycleDFS(v, visited, recpath, adj)) {
                    return true;
                }
            } else if (recpath[v]) {
                return true; // back edge → cycle
            }
        }

        recpath[src] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(v).add(u); // u depends on v
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recpath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCycleDFS(i, visited, recpath, adj)) {
                    return false; // cycle detected
                }
            }
        }
        return true; // no cycle → all courses can be finished
    }
}

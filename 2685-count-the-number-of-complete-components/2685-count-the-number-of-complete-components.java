import java.util.*;

class DSU {

    int[] parent, size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;   // each node is its own parent initially
            size[i] = 1;     // size of each set starts as 1
        }
    }

    // Find with path compression
    int find(int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }

    // Union by size
    void unite(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return; // already in same set

        // attach smaller set under larger set
        if (size[u] < size[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        parent[v] = u;
        size[u] += size[v];
    }

    // Get size of the set containing u
    int getSize(int u) {
        return size[find(u)];
    }
}

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int[] degree = new int[n]; // degree of each node

        // Build DSU and degree array
        for (int[] e : edges) {
            dsu.unite(e[0], e[1]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        // Group nodes by their DSU parent
        Map<Integer, List<Integer>> compMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            compMap.putIfAbsent(root, new ArrayList<>());
            compMap.get(root).add(i);
        }

        int ans = compMap.size();

        // Check each component if it is complete
        for (Map.Entry<Integer, List<Integer>> entry : compMap.entrySet()) {
            int root = entry.getKey();
            List<Integer> nodes = entry.getValue();
            int sz = dsu.getSize(root);

            boolean complete = true;
            for (int node : nodes) {
                // In a complete graph, each node has degree = size - 1
                if (degree[node] != sz - 1) {
                    complete = false;
                    break;
                }
            }

            if (!complete) ans--;
        }

        return ans;
    }
}

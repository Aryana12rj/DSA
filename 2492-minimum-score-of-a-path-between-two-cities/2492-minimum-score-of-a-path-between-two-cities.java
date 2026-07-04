class Solution {
    // 🔹 Find function with path compression
    // This returns the "root" (representative) of a node in the Union-Find structure.
    int find(int[] root, int i) {
        if (root[i] == i) 
            return i; // If node is its own parent, it's the root.
        return root[i] = find(root, root[i]); 
        // Path compression: directly connect node to its ultimate root.
    }

    public int minScore(int n, int[][] roads) {
        // 🔹 Step 1: Initialize Union-Find parent array
        int[] root = new int[n + 1]; 
        for (int i = 0; i <= n; i++) 
            root[i] = i; // Initially, each node is its own parent.

        // 🔹 Step 2: Union operation for all roads
        // Connect the two cities of each road into the same component.
        for (int[] r : roads) 
            root[find(root, r[0])] = find(root, r[1]);

        // 🔹 Step 3: Find minimum edge weight among roads connected to city 1
        int res = 10001; // Max possible edge weight is 10^4, so start with a safe upper bound.
        for (int[] r : roads) {
            // If this road belongs to the same connected component as city 1
            if (find(root, r[0]) == find(root, 1)) 
                res = Math.min(res, r[2]); // Update minimum edge weight.
        }

        // 🔹 Step 4: Return the minimum score
        return res;
    }
}

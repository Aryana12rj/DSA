import java.util.*;

class DisjointSet {
    int[] parent;
    int[] size;
    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  
            size[i] = 1;    
        }
    }

    public int findUPar(int node) {
        if (parent[node] == node) return node;
        parent[node] = findUPar(parent[node]); 
        return parent[node];
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return; 

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        // Map each email to its account index
        Map<String, Integer> emailToAccount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!emailToAccount.containsKey(email)) {
                    emailToAccount.put(email, i);
                } else {
                    ds.unionBySize(i, emailToAccount.get(email));
                }
            }
        }

        // Collect emails for each ultimate parent
        Map<Integer, TreeSet<String>> mergedAccounts = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {
            String email = entry.getKey();
            int accountIndex = ds.findUPar(entry.getValue());
            mergedAccounts.putIfAbsent(accountIndex, new TreeSet<>());
            mergedAccounts.get(accountIndex).add(email);
        }

        // Build final result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry : mergedAccounts.entrySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(entry.getKey()).get(0)); // account name
            merged.addAll(entry.getValue()); // sorted emails
            result.add(merged);
        }

        return result;
    }
}

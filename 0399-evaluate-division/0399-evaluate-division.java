class Solution {
    Map<String, Map<String, Double>> graph;
    private double bfs(String c1, String c2){
        Queue<Pair<String,Double>> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.offer(new Pair<>(c1, 1.0));
        vis.add(c1);
        while(!q.isEmpty()){
            Pair<String, Double> current = q.poll();
            String node = current.getKey();
            double product = current.getValue();
            if(node.equals(c2)){
                return product;
            }
            Map<String, Double> neighbors = graph.get(node);
            for(String nei : neighbors.keySet()){
                if(!vis.contains(nei)){
                    vis.add(nei);
                    double newProduct = product * neighbors.get(nei);
                    q.offer(new Pair<>(nei, newProduct));
                }
            }
        }
        return -1.0;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            List<String> l = equations.get(i);
            String c1 = l.get(0);
            String c2 = l.get(1);
            double w1 = values[i];
            double w2 = 1.0/values[i];
            graph.putIfAbsent(c1, new HashMap<>());
            graph.get(c1).put(c2, w1);
            graph.putIfAbsent(c2, new HashMap<>());
            graph.get(c2).put(c1, w2);
        }
        
        double[] ans = new double[queries.size()];
        int i = 0;
        for(List<String> l : queries){
            String c1 = l.get(0);
            String c2 = l.get(1);
            if(!graph.containsKey(c1) || !graph.containsKey(c2)){
                ans[i] = -1.0;
            }
            else if(c1.equals(c2)){
                ans[i] = 1.0;
            }
            else{
                double val = bfs(c1, c2);
                ans[i] = val;
            }
            i++;
        }
        return ans;
    }
}

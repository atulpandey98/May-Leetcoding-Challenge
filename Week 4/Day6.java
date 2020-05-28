// Possible Bipartition
// Time Complexity - O(N + E) , E is the length of dislikes array.
// Space Complexity - O(N + E)

class Solution {
    List<List<Integer>> graph;
    Map<Integer, Integer> color;
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList<>();
        for (int i = 1; i <= N + 1; ++i) {
            graph.add(new ArrayList());
        }            

        for (int[] edge : dislikes) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    
        color = new HashMap<>();
        for (int node = 1; node <= N; ++node) {
            if (!color.containsKey(node) && !dfs(node, 0)) 
                return false;
        }
            
        return true;
    }

    public boolean dfs(int node, int c) {
        if (color.containsKey(node)) {
            return color.get(node) == c;
        }
            
        
        color.put(node, c);

        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, c ^ 1))  // if c is 0, 0 ^ 1 is 1. If c is 1, 1 ^ 1 is 0.
                return false;
        }
            
        return true;
    }
}

// Question: Directed Graph Cycle... 
// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
// The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.

// Examples:
// Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 3], [3, 3]]
// Output: true

package shreyam.gfg;

import java.util.ArrayList;

public class DirectedGraphCycle {
    public static boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        
        int n = adj.size();
        
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!vis[i] && dfs(i, adj, vis, path)) {
                return true;
            }
        }
        
        return false;
    }
    
    private static boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] path) {
        vis[i] = true;
        path[i] = true;
    
        
        for (int node : adj.get(i)) {
            if (path[node]) {
                return true;
            }
            
            if (!vis[node]) {
                if (dfs(node, adj, vis, path)) {
                    return true;
                }
            }
        }
        
        path[i] = false;
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        int edges[][] = {{0, 1}, {1, 2}, {2, 3}, {3, 3}};
        boolean res = isCyclic(V, edges);
        System.out.println(res);
    }
}

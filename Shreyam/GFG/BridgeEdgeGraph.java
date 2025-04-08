// Question: Bridge edge in a graph... 
// Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u,v] represents the edge between the vertices u and v. Determine whether a specific edge between two vertices (c, d) is a bridge.
// An edge is called a bridge if removing it increases the number of connected components of the graph.
// if there’s only one path between c and d (which is the edge itself), then that edge is a bridge.

// Examples :
// Input:
// c = 1, d = 2
// Output: true

package shreyam.gfg;

import java.util.ArrayList;
import java.util.List;

public class BridgeEdgeGraph {
    public static boolean isBridge(int V, int[][] edges, int c, int d) {
        List<List<Integer>> adj = new ArrayList<>();
        
        // Create adjacency list
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // Count components before removing the edge
        int initialComponents = countComponents(V, adj);
        
        // Remove the edge (c, d)
        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));
        
        // Count components after removing the edge
        int newComponents = countComponents(V, adj);
        
        // If components increase, it is a bridge
        return newComponents > initialComponents;
    }
    
    private static int countComponents(int V, List<List<Integer>> adj){
        boolean[] visited = new boolean[V];
        int components = 0;
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                components++;
                dfs(i, visited, adj);
            }
        }
        return components;
    }
    
    private static void dfs(int node, boolean[] visited, List<List<Integer>> adj){
        visited[node] = true;
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, visited, adj);
            }
        }
    }
    public static void main(String[] args) {
        // int V = 4;  
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {0, 3}
        };
        int c =1;
        int d =2;
        boolean res = isBridge(d, edges, c, d);
        System.out.println(res);
    }
}

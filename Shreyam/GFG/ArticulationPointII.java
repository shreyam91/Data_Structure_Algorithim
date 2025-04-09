// Question: Articulation Point - II... 
// You are given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
// Your task is to return all the articulation points (or cut vertices) in the graph.
// An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.
// Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
// If no such point exists, return {-1}.

// Examples :
// Input: V = 5, edges[][] = [[0, 1], [1, 4], [4, 3], [4, 2], [2, 3]]
// Output: [1, 4]

package shreyam.gfg;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPointII {
    public static void dfs(int u, int parent, ArrayList<Integer>[] adj, int[] tin, int[] low, 
                    boolean[] vis, boolean[] isArticulation, int timer) {
        vis[u] = true;
        tin[u] = low[u] = timer++;
        int children = 0;
        
        for (int v : adj[u]) {
            if (v == parent) continue; 
            if (!vis[v]) {
                dfs(v, u, adj, tin, low, vis, isArticulation, timer);
                low[u] = Math.min(low[u], low[v]);
                
                if (low[v] >= tin[u] && parent != -1) {
                    isArticulation[u] = true;
                }
                children++;
            } else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }
        
        if (parent == -1 && children > 1) {
            isArticulation[u] = true;
        }
    }
    
    public static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        
        int[] tin = new int[V];
        int[] low = new int[V];
        Arrays.fill(tin, -1);
        Arrays.fill(low, -1);
        
        boolean[] vis = new boolean[V];
        boolean[] isArticulation = new boolean[V];
        
        int timer = 0;
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, adj, tin, low, vis, isArticulation, timer);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) {
                result.add(i);
            }
        }
        
        if (result.isEmpty()) {
            result.add(-1);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1}, {1, 4}, {4, 3}, {4, 2}, {2, 3}
        };
        
        ArrayList<Integer> articulationPoints = articulationPoints(V, edges);
        
        System.out.println(articulationPoints);
    }
}

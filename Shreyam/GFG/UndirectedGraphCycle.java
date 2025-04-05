// Question: Undirected Graph Cycle... 
// Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not.

// Examples:

// Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
// Output: true

package shreyam.gfg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphCycle {

    public static boolean helper(int start, List<Integer>[] adj, boolean[] vis) {
        vis[start] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{-1, start});
        
        while (!q.isEmpty()) {
            int parent = q.peek()[0];
            int node = q.peek()[1];
            q.poll();
            
            for (int it : adj[node]) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.offer(new int[]{node, it});
                } else if (it != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        boolean[] vis = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (helper(i, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        // int E = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};

        boolean res = isCycle(V, edges);
        System.out.println(res);  
    }
}

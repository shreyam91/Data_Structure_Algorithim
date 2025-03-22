// Question: Count the Number of Complete Components... 

// You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.
// Return the number of complete connected components of the graph.
// A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
// A connected component is said to be complete if there exists an edge between every pair of its vertices.

// Example 1:
// Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
// Output: 3

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question2685 {
    private static void dfs(int curr, int[] nodes, int[] edges, List<List<Integer>> adj, boolean[] visited) {
            nodes[0]++;
            visited[curr] = true;
            for (int nbr : adj.get(curr)) {
                edges[0]++;
                if (!visited[nbr]) {
                    dfs(nbr, nodes, edges, adj, visited);
                }
            }
        }
    
        public static int countCompleteComponents(int n, int[][] edges) {
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
            int completeComponents = 0;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int[] nodes = new int[1];
                    int[] edgesCount = new int[1];
                    dfs(i, nodes, edgesCount, adj, visited);
                if (edgesCount[0] == nodes[0] * (nodes[0] - 1)) {
                    completeComponents++;
                }
            }
        }
        return completeComponents;
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        int res = countCompleteComponents(n, edges);
        System.out.println(res);
    }
}

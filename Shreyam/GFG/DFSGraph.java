// Question: DFS of Graph... 
// Given a connected undirected graph represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a Depth First Search (DFS) traversal starting from vertex 0, visiting vertices from left to right as per the given adjacency list, and return a list containing the DFS traversal of the graph.
// Note: Do traverse in the same order as they are in the given adjacency list.

// Examples:

// Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
// Output: [0, 2, 4, 3, 1]

package shreyam.gfg;

import java.util.*;

public class DFSGraph {

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        dfsUtil(0, visited, ans, adj);
        
        return ans;
    }

    public static void dfsUtil(int idx, int[] visited, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj){
        visited[idx] = 1;
        ans.add(idx);

        for (int i = 0; i < adj.get(idx).size(); i++) {
            if (visited[adj.get(idx).get(i)] == -1) {
                dfsUtil(adj.get(idx).get(i), visited, ans, adj);
            }
        }
    }

    public static void main(String[] args) {
        int adj[][] = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        
        int N = adj.length; 
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                g.get(i).add(adj[i][j]);
            }
        }

        ArrayList<Integer> res = dfs(g);

        for (int node : res) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}

// Question: Count the paths 

// Given a Directed Acyclic Graph (DAG) with V nodes labeled from 0 to V-1, and a list of directed edges, count the total number of distinct paths from a given start node to a destination node. Each edge is represented as edges[i] = [u, v], indicating a directed edge from u to v.

// Examples :
// Input: edges[][] = [[0,1], [0,3], [2,0], [2,1], [1,3]], V = 4, src = 2, dest = 3
// Output: 3

package shreyam.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountThePaths{
    public static int dfs(int u, int dest, List<List<Integer> > adj, int[] dp) {
        if (u == dest) {
            return 1;
        }

        if (dp[u] != -1) {
            return dp[u];
        }

        int count = 0;

        for (int v : adj.get(u)) {
            count += dfs(v, dest, adj, dp);  
        }

        return dp[u] = count;  
    }
    public static int countPaths(int[][] edges, int V, int src, int dest) {
        List<List<Integer> > adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);  
        }

        int[] dp = new int[1001];
        Arrays.fill(dp, -1);

        return dfs(src, dest, adj, dp);
    }
    public static void main(String[] args) {
        int edges[][] = {{0,1}, {0,3}, {2,0}, {2,1}, {1,3}};
        int V = 4, src = 2, dest = 3;
        System.out.println(countPaths(edges, V, src, dest));
    }
}

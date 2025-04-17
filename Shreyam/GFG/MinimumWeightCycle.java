// Question: Minimum Weight Cycle... 
// Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by a 2d array edges[][], where edges[i] = [u, v, w] represents the edge between the nodes u and v having w edge weight.
// Your task is to find the minimum weight cycle in this graph.

// Examples:

// Input: V = 5, edges[][] = [[0, 1, 2], [1, 2, 2], [1, 3, 1], [1, 4, 1], [0, 4, 3], [2, 3, 4]]
// Output: 6

package shreyam.gfg;

import java.util.Arrays;

public class MinimumWeightCycle {
    public int findMinCycle(int V, int[][] edges) {
        final int INF = 100000000;  
        int[][] dist = new int[V][V];
        int[][] adj = new int[V][V];  

        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            Arrays.fill(adj[i], INF);
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj[u][v] = adj[v][u] = Math.min(adj[u][v], w);  
            dist[u][v] = dist[v][u] = Math.min(dist[u][v], w); 
        }

        for (int i = 0; i < V; i++) {
            dist[i][i] = 0;
        }

        int minCycle = INF;

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < k; i++) {
                for (int j = i + 1; j < k; j++) {
                    if (dist[i][j] < INF && adj[i][k] < INF && adj[k][j] < INF) {
                        int cycleWeight = dist[i][j] + adj[i][k] + adj[k][j];
                        minCycle = Math.min(minCycle, cycleWeight);
                    }
                }
            }

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        return (minCycle == INF) ? -1 : minCycle;
    }
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1, 2},
            {1, 2, 2},
            {1, 3, 1},
            {1, 4, 1},
            {0, 4, 3},
            {2, 3, 4}
        };

        MinimumWeightCycle mwc = new MinimumWeightCycle();
        int result = mwc.findMinCycle(V, edges);
        System.out.println("Minimum Cycle Weight: " + result);
    }
}

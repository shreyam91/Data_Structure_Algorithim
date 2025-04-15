// Question: Bellman-Ford... 
// Given an weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by a 2d array edges[][], where edges[i] = [u, v, w] represents a direct edge from node u to v having w edge weight. You are also given a source vertex src.
// Your task is to compute the shortest distances from the source to all other vertices. If a vertex is unreachable from the source, its distance should be marked as 108. Additionally, if the graph contains a negative weight cycle, return [-1] to indicate that shortest paths cannot be reliably computed.

// Examples:
// Input: V = 5, edges[][] = [[1, 3, 2], [4, 3, -1], [2, 4, 1], [1, 2, 1], [0, 1, 5]], src = 0
// Output: [0, 5, 6, 6, 7]

package shreyam.gfg;

import java.util.Arrays;

public class BellmanFord {
    public static int[] bellmanFord(int n, int[][] edges, int S) {
        int[] ans = new int[n];
        Arrays.fill(ans, (int)1e8);
        ans[S] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (ans[u] != (int)1e8 && ans[u] + wt < ans[v]) {
                    ans[v] = ans[u] + wt;
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (ans[u] != (int)1e8 && ans[u] + wt < ans[v]) {
                return new int[]{-1}; 
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {1, 3, 2},
            {4, 3, -1},
            {2, 4, 1},
            {1, 2, 1},
            {0, 1, 5}
        };
        int src = 0;

        int[] result = bellmanFord(V, edges, src);

        for (int dist : result) {
            System.out.print((dist == (int)1e8 ? "INF" : dist) + " ");
        }
    }
}


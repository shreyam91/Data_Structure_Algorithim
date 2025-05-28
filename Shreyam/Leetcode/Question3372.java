// Question: Maximize the Number of Target Nodes After Connecting Trees I

// Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2

// Output: [9,7,9,8,8]

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question3372{
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static int BFS(int start, List<List<Integer>> adj, int k) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        int count = 0;

        while (!q.isEmpty() && k >= 0) {
            int size = q.size();
            count += size;
            for (int i = 0; i < size; ++i) {
                Pair curr = q.poll();
                int u = curr.first;
                int parent = curr.second;
                for (int v : adj.get(u)) {
                    if (v != parent) {
                        q.add(new Pair(v, u));
                    }
                }
            }
            k--;
        }
        return count;
    }

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int m = edges1.length + 1;
        int n = edges2.length + 1;

        // Build adjacency lists for tree 1
        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            adj1.add(new ArrayList<>());
        }
        for (int[] edge : edges1) {
            adj1.get(edge[0]).add(edge[1]);
            adj1.get(edge[1]).add(edge[0]);
        }

        // Build adjacency lists for tree 2
        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj2.add(new ArrayList<>());
        }
        for (int[] edge : edges2) {
            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
        }

        // Preprocess: Find the best node in Tree-2
        int best = 0;
        for (int i = 0; i < n; ++i) {
            int connections = BFS(i, adj2, k - 1);
            best = Math.max(best, connections);
        }

        // Build answer
        int[] res = new int[m];
        for (int i = 0; i < m; ++i) {
            int connections = BFS(i, adj1, k);
            res[i] = connections + best;
        }
        return res;
    }
    public static void main(String[] args) {
        int [][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int [][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        int k = 2;

        System.out.println( Arrays.toString(maxTargetNodes(edges1, edges2, k)));
    }
}
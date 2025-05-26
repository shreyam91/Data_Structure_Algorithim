// Question: Largest Color Value in  Directed graph 

// There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.
// You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.
// A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.
// Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.

// Example 1:
// Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
// Output: 3

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Question1857 {
    private static int dfs(int curr, List<List<Integer>> adj, int[] visited, int[][] longest, String colors) {
        if (visited[curr] == 1) 
            return Integer.MAX_VALUE;
        
        if (visited[curr] == 0) { 
            visited[curr] = 1;
            for (int nbr : adj.get(curr)) {
                int res = dfs(nbr, adj, visited, longest, colors);
                if (res == Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                
                for (int i = 0; i < 26; ++i)
                    longest[i][curr] = Math.max(longest[i][curr], longest[i][nbr]);
            }
            longest[colors.charAt(curr) - 'a'][curr]++;
            visited[curr] = 2;
        }
        return longest[colors.charAt(curr) - 'a'][curr];
    }

    public static int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        for (int[] edge : edges)
            adj.get(edge[0]).add(edge[1]);

        int[][] longest = new int[26][n];
        int maxColorLength = 0;
        int[] visited = new int[n];
        
        for (int i = 0; i < n; ++i) {
            int res = dfs(i, adj, visited, longest, colors);
            if (res == Integer.MAX_VALUE)
                return -1;
            maxColorLength = Math.max(maxColorLength, res);
        }
        return maxColorLength;
    }
    public static void main(String[] args) {
        String colors = "abaca";
        int[][] edges = {{0,1},{0,2},{2,3},{3,4}};
        System.out.println(largestPathValue(colors, edges));
    }
}

// Question: Minimum Cost Walk in Weighted Graph... 
//There is an undirected weighted graph with n vertices labeled from 0 to n - 1.
// You are given the integer n and an array edges, where edges[i] = [ui, vi, wi] indicates that there is an edge between vertices ui and vi with a weight of wi.
// A walk on a graph is a sequence of vertices and edges. The walk starts and ends with a vertex, and each edge connects the vertex that comes before it and the vertex that comes after it. It's important to note that a walk may visit the same edge or vertex more than once.
// The cost of a walk starting at node u and ending at node v is defined as the bitwise AND of the weights of the edges traversed during the walk. In other words, if the sequence of edge weights encountered during the walk is w0, w1, w2, ..., wk, then the cost is calculated as w0 & w1 & w2 & ... & wk, where & denotes the bitwise AND operator.
// You are also given a 2D array query, where query[i] = [si, ti]. For each query, you need to find the minimum cost of the walk starting at vertex si and ending at vertex ti. If there exists no such walk, the answer is -1.
// Return the array answer, where answer[i] denotes the minimum cost of a walk for query i.

// Example 1:
// Input: n = 5, edges = [[0,1,7],[1,3,7],[1,2,1]], query = [[0,3],[3,4]]
// Output: [1,-1]

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question3108 {
    private static int find(int[] dsuf, int v) {
            if (dsuf[v] == -1) {
                return v;
            }
            return dsuf[v] = find(dsuf, dsuf[v]); 
        }
    
        private static void traverseComponent(int[] bitwiseAnd, int curr, boolean[] visited, List<List<int[]>> adj) {
                    visited[curr] = true;
                    for (int[] edge : adj.get(curr)) {
                        int nbr = edge[0], wt = edge[1];
                        bitwiseAnd[0] &= wt; 
                        if (!visited[nbr]) {
                            traverseComponent(bitwiseAnd, nbr, visited, adj);
                        }
                    }
                }
            
                public static int[] minimumCost(int n, int[][] edges, int[][] query) {
                        int[] dsuf = new int[n];
                        Arrays.fill(dsuf, -1);
                        List<List<int[]>> adj = new ArrayList<>();
                        for (int i = 0; i < n; i++) {
                            adj.add(new ArrayList<>());
                        }
                
                        for (int[] edge : edges) {
                            int u = edge[0], v = edge[1], wt = edge[2];
                            adj.get(u).add(new int[]{v, wt});
                            adj.get(v).add(new int[]{u, wt});
                
                            int px = find(dsuf, u);
                        int py = find(dsuf, v);
                        if (px != py) {
                            dsuf[px] = py; 
                        }
                    }
            
                    Map<Integer, Integer> parentCost = new HashMap<>();
                    boolean[] visited = new boolean[n];
                    for (int i = 0; i < n; i++) {
                        if (!visited[i]) {
                            int[] bitwiseAnd = new int[]{adj.get(i).isEmpty() ? 0 : adj.get(i).get(0)[1]};
                            traverseComponent(bitwiseAnd, i, visited, adj);
                    int parent = find(dsuf, i);
                    parentCost.put(parent, bitwiseAnd[0]);
                }
            }
    
            int[] ans = new int[query.length];
            for (int i = 0; i < query.length; i++) {
                int px = find(dsuf, query[i][0]);
                int py = find(dsuf, query[i][1]);
                if (px == py) {
                    ans[i] = parentCost.get(px);
                } else {
                    ans[i] = -1;
                }
            }
    
            return ans;
        }
        public static void main(String[] args) {
            int n =5;
            int edges [][] = {{0,1,7},{1,3,7},{1,2,1}};
            int query [][] = {{0,3},{3,4}};
    
            int res [] = minimumCost(n, edges, query);

        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + " ");
        }

    }
}

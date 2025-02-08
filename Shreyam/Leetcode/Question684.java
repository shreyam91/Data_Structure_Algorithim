// Question: Reduntant Connection... 
// In this problem, a tree is an undirected graph that is connected and has no cycles.
// You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

// Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
// Input: edges = [[1,2],[1,3],[2,3]]
// Output: [2,3]

package shreyam.leetCode;

import java.util.Arrays;

public class Question684 {
    private static int find(int[] dsuf, int v) {
            if (dsuf[v] == -1) 
                return v;
            return dsuf[v] = find(dsuf, dsuf[v]); 
        }
    
        public static int[] findRedundantConnection(int[][] edges) {
            int n = edges.length;
            int[] dsuf = new int[n + 1];
            Arrays.fill(dsuf, -1);
    
            for (int[] edge : edges) {
                int parentX = find(dsuf, edge[0]);
            int parentY = find(dsuf, edge[1]);

            if (parentX == parentY) 
                return edge;
            else 
                dsuf[parentX] = parentY;
        }
        return new int[]{0, 0};
    }
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        int[] redundantEdge = findRedundantConnection(edges);
        System.out.println("Redundant edge: " + Arrays.toString(redundantEdge));
    }
}

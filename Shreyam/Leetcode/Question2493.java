// Question: Divide Nodes into the maximum Number Of groups... 
// You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.
// You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge between nodes ai and bi. Notice that the given graph may be disconnected.
// Divide the nodes of the graph into m groups (1-indexed) such that:
// Each node in the graph belongs to exactly one group.
// For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x, and bi belongs to the group with index y, then |y - x| = 1.
// Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is impossible to group the nodes with the given conditions.

// Input: n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
// Output: 4
// Explanation: As shown in the image we:
// - Add node 5 to the first group.
// - Add node 1 to the second group.
// - Add nodes 2 and 4 to the third group.
// - Add nodes 3 and 6 to the fourth group.
// We can see that every edge is satisfied.
// It can be shown that that if we create a fifth group and move any node from the third or fourth group to it, at least on of the edges will not be satisfied.

package Shreyam.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question2493 {
    private static boolean isComponentBipartite(List<List<Integer>> adj, int[] state, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        state[start] = 1;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int nbr : adj.get(curr)) {
                if (state[nbr] == 0) {
                    state[nbr] = -state[curr];  
                    q.offer(nbr);
                } else if (state[nbr] == state[curr]) {
                    return false;  
                }
            }
        }
        return true;
    }
    
    private static  boolean checkBipartiteGraph(List<List<Integer>> adj, int n) {
        int[] state = new int[n + 1];
        Arrays.fill(state, 0);
        
        for (int i = 1; i <= n; i++) {
            if (state[i] == 0 && !isComponentBipartite(adj, state, i)) {
                return false;
            }
        }
        return true;
    }
    
    private static int countLevels(List<List<Integer>> adj, int n, int source) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;
        
        int levels = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                
                for (int nbr : adj.get(curr)) {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        q.offer(nbr);
                    }
                }
            }
            levels++;
        }
        return levels;
    }
    
    private static  int findMaxLevelsBFS(int[] maxDistance, List<List<Integer>> adj, boolean[] visited, int source) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;
        
        int maxLevels = -1;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            maxLevels = Math.max(maxLevels, maxDistance[curr]);
            for (int nbr : adj.get(curr)) {
                if (!visited[nbr]) {
                    visited[nbr] = true;
                    q.offer(nbr);
                }
            }
        }
        return maxLevels;
    }
    public static  int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if (!checkBipartiteGraph(adj, n)) {
            return -1;
        }

        int[] maxDistance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            maxDistance[i] = countLevels(adj, n, i);
        }

        boolean[] visited = new boolean[n + 1];
        int totalLevels = 0;
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                totalLevels += findMaxLevelsBFS(maxDistance, adj, visited, i);
            }
        }
        
        return totalLevels;
    }
    public static void main(String[] args) {
        int num = 6;
        int[][] edges = {{1,2},{1,4},{1,5},{2,6},{2,3},{4,6}};
        int result = magnificentSets(num, edges);
        System.out.println("Result: " + result);
    }
}

// Question: Topological sort... 
// Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes an directed edge u -> v. Return topological sort for the given graph.
// Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
// Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.

// Examples:
// Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]
// Output: true

package shreyam.gfg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[V];
        
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            indegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topologicalOrder.add(u);
            
            for (int v : adjList.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
      
        return (topologicalOrder.size() == V) ? topologicalOrder : new ArrayList<>();
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
            {3, 0},
            {1, 0},
            {2, 0}
        };
        
        ArrayList<Integer> result = topoSort(V, edges);
        
        System.out.println(result); 
    }
}

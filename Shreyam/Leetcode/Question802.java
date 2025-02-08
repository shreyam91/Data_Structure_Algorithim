// Question: Find Eventual Safe State... 
// There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

// A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

// Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
// Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
// Output: [2,4,5,6]
// Explanation: The given graph is shown above.
// Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
// Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.

package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question802 {
    private static boolean[] safeNodes;
    
        private static boolean checkSafeState(List<List<Integer>> graph, int[] visited, int curr) {
                    visited[curr] = 1; 
                    boolean isSafe = true;
            
                    for (int neighbor : graph.get(curr)) {
                        if (visited[neighbor] == 0) { 
                            isSafe &= checkSafeState(graph, visited, neighbor);
                        } else if (visited[neighbor] == 1) { 
                            safeNodes[curr] = false;
                            return false;
                        } else if (visited[neighbor] == 2) { 
                            isSafe &= safeNodes[neighbor];
                        }
                    }
            
                    visited[curr] = 2; 
                    safeNodes[curr] = isSafe;
                    return isSafe;
                }
            
                public static List<Integer> eventualSafeNodes(int[][] graph) {
                    int n = graph.length;
                    safeNodes = new boolean[n]; 
                Arrays.fill(safeNodes, true); 
        
                int[] visited = new int[n]; 
        
                List<List<Integer>> graphList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    List<Integer> neighbors = new ArrayList<>();
                    for (int neighbor : graph[i]) {
                        neighbors.add(neighbor);
                    }
                    graphList.add(neighbors);
                }
        
                for (int i = 0; i < n; i++) {
                    if (visited[i] == 0) {
                        checkSafeState(graphList, visited, i);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safeNodes[i]) {
                result.add(i);
            }
        }
        return result;
    }
 public static void main(String[] args) {
    int[][] graph = {
        {1, 2}, 
        {2, 3}, 
        {5}, 
        {0}, 
        {5}, 
        {}, 
        {}
    };

    List<Integer> safeNodes = eventualSafeNodes(graph);
    System.out.println(safeNodes);
 }   
}

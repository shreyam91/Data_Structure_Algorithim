// Question: Maximum Employees to be Invited to a Meeting... 
// A company is organizing a meeting and has a list of n employees, waiting to be invited. They have arranged for a large circular table, capable of seating any number of employees.

// The employees are numbered from 0 to n - 1. Each employee has a favorite person and they will attend the meeting only if they can sit next to their favorite person at the table. The favorite person of an employee is not themself.

// Given a 0-indexed integer array favorite, where favorite[i] denotes the favorite person of the ith employee, return the maximum number of employees that can be invited to the meeting.
// Input: favorite = [2,2,1,2]
// Output: 3
// Explanation:
// The above figure shows how the company can invite employees 0, 1, and 2, and seat them at the round table.
// All employees cannot be invited because employee 2 cannot sit beside employees 0, 1, and 3, simultaneously.
// Note that the company can also invite employees 1, 2, and 3, and give them their desired seats.
// The maximum number of employees that can be invited to the meeting is 3. 

package Shreyam.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question2127 {
    private static int kahnsTopologicalSort(int[] adj, int[] indegree, boolean[] visited, int source) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(source);
    
            int lastNode = -1;
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                visited[curr] = true;
                lastNode = curr;
    
                int neighbor = adj[curr];
                indegree[neighbor]--;
                if (indegree[neighbor] == 0 && !visited[neighbor]) {
                    queue.offer(neighbor);
                }
            }
            return adj[lastNode];
        }
    
        private static int maxDepthBFS(List<List<Integer>> reverseAdj, boolean[] origVisited, int n, int source, int avoid) {
                    boolean[] visited = new boolean[n];
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(source);
                    visited[source] = true;
                    visited[avoid] = true;
            
                    int levels = 0;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                            int curr = queue.poll();
                            origVisited[curr] = true;
            
                            for (int neighbor : reverseAdj.get(curr)) {
                                if (!visited[neighbor]) {
                                    visited[neighbor] = true;
                                    queue.offer(neighbor);
                                }
                            }
                        }
                        levels++;
                    }
                    return levels;
                }
            
                private static int bfs(int[] adj, boolean[] visited, int source) {
                                    Queue<Integer> queue = new LinkedList<>();
                                    queue.offer(source);
                                    visited[source] = true;
                            
                                    int count = 0;
                                    while (!queue.isEmpty()) {
                                        int curr = queue.poll();
                            
                                        if (!visited[adj[curr]]) {
                                            visited[adj[curr]] = true;
                                            queue.offer(adj[curr]);
                                        }
                                        count++;
                                    }
                                    return count;
                                }
                            
                                public static int maximumInvitations(int[] adj) {
                                    int n = adj.length;
                                    List<List<Integer>> reverseAdj = new ArrayList<>();
                                    for (int i = 0; i < n; i++) reverseAdj.add(new ArrayList<>());
                                    int[] indegree = new int[n];
                            
                                    for (int i = 0; i < n; i++) {
                                        reverseAdj.get(adj[i]).add(i);
                                        indegree[adj[i]]++;
                                    }
                            
                                    int totalTailLen = 0;
                                    boolean[] visited = new boolean[n];
                                    for (int i = 0; i < n; i++) {
                                        if (indegree[i] == 0 && !visited[i]) {
                                            int node = kahnsTopologicalSort(adj, indegree, visited, i);
                                        if (adj[adj[node]] == node) {
                                            int lenTail = maxDepthBFS(reverseAdj, visited, n, node, adj[node]) - 1;
                                    totalTailLen += lenTail;
                                    visited[node] = false;
                                }
                            }
                        }
                
                        int twoSizeCycles = 0;
                        int maxCycleSize = 0;
                        for (int i = 0; i < n; i++) {
                            if (!visited[i]) {
                                int cycleSize = bfs(adj, visited, i);
                if (cycleSize == 2) {
                    twoSizeCycles++;
                } else {
                    maxCycleSize = Math.max(maxCycleSize, cycleSize);
                }
            }
        }

        int cycleSize2 = totalTailLen + 2 * twoSizeCycles;
        return Math.max(cycleSize2, maxCycleSize);
    }
    public static void main(String[] args) {
        int [] arr = {2,2,1,2};
        int res = maximumInvitations(arr);
        System.out.println(res);
    }
}

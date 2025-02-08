// Question: Course Schedule IV.... 
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi.
// For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
// Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.
// You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.
// Return a boolean array answer, where answer[j] is the answer to the jth query.

// Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
// Output: [false,true]
// Explanation: The pair [1, 0] indicates that you have to take course 1 before you can take course 0.
// Course 0 is not a prerequisite of course 1, but the opposite is true.

package Shreyam.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int INT_MAX = 10000;
        int[][] dist = new int[numCourses][numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            Arrays.fill(dist[i], INT_MAX);
            dist[i][i] = 0; 
        }
        
        for (int[] edge : prerequisites) {
            dist[edge[0]][edge[1]] = 1;
        }
        
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (dist[i][k] != INT_MAX && dist[k][j] != INT_MAX && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(dist[query[0]][query[1]] < INT_MAX);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}

// Question: Maximum Number of Points from Grid Queries... 

// You are given an m x n integer matrix grid and an array queries of size k.
// Find an array answer of size k such that for each integer queries[i] you start in the top left cell of the matrix and repeat the following process:
// If queries[i] is strictly greater than the value of the current cell that you are in, then you get one point if it is your first time visiting this cell, and you can move to any adjacent cell in all 4 directions: up, down, left, and right.
// Otherwise, you do not get any points, and you end this process.
// After the process, answer[i] is the maximum number of points you can get. Note that for each query you are allowed to visit the same cell multiple times.

// Return the resulting array answer.
// Example 1:
// Input: grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]
// Output: [5,8,1]

package shreyam.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Question2503 {
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Triple {
        int first;
        Pair second;
        Triple(int first, Pair second) {
            this.first = first;
            this.second = second;
        }
    }

    static boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static int[] maxPoints(int[][] grid, int[] queries) {
        Set<Integer> sortedQueries = new TreeSet<>();
        for (int query : queries) sortedQueries.add(query);

        Map<Integer, Integer> queryCount = new HashMap<>();
        PriorityQueue<Triple> minheap = new PriorityQueue<>((a, b) -> a.first - b.first);
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        minheap.add(new Triple(grid[0][0], new Pair(0, 0)));
        visited[0][0] = true;
        int[] dir = {-1, 0, 1, 0, -1};

        int count = 0;
        for (int query : sortedQueries) {
            while (!minheap.isEmpty()) {
                Triple curr = minheap.poll();
                int val = curr.first;
                int x = curr.second.first;
                int y = curr.second.second;
                if (val >= query) {
                    minheap.add(curr);
                    break;
                }
                count++;

                for (int i = 0; i < 4; i++) {
                    int newX = x + dir[i];
                    int newY = y + dir[i + 1];
                    if (isValid(newX, newY, m, n) && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        minheap.add(new Triple(grid[newX][newY], new Pair(newX, newY)));
                    }
                }
            }
            queryCount.put(query, count);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = queryCount.get(queries[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int grid [][] = {{1,2,3},{2,5,7},{3,5,1}};
        int queries [] = {5,6,2};
        int res [] = maxPoints(grid, queries);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }
}

// Question: Map Of Highest Peak... 
// You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
// If isWater[i][j] == 0, cell (i, j) is a land cell.
// If isWater[i][j] == 1, cell (i, j) is a water cell.
// You must assign each cell a height in a way that follows these rules:
// The height of each cell must be non-negative.
// If the cell is a water cell, its height must be 0.
// Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
// Find an assignment of heights such that the maximum height in the matrix is maximized.
// Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.

// Input: isWater = [[0,1],[0,0]]
// Output: [[1,0],[2,1]]
// Explanation: The image shows the assigned heights of each cell.
// The blue cell is the water cell, and the green cells are the land cells.

package Shreyam.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Question1765 {
    public static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[] dir = {-1, 0, 1, 0};
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for (int d = 0; d < 4; ++d) {
                    int newX = x + dir[d];
                    int newY = y + dir[(d + 1) % 4]; 
                    if (isValid(newX, newY, m, n) && !visited[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        height[newX][newY] = 1 + level;
                        visited[newX][newY] = true;
                    }
                }
            }
            level++;
        }
        return height;
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public static void printResult(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
        
    public static void main(String[] args) {
        int [][] arr = {{0,1},{0,0}};
        int res [][] = highestPeak(arr);
        System.out.println(res);
    }
}

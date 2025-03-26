// Question: Minimum Operations to Make a Uni-Value Grid... 
// You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.
// A uni-value grid is a grid where all the elements of it are equal.
// Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.

// Example 1:
// Input: grid = [[2,4],[6,8]], x = 2
// Output: 4
package shreyam.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question2033 {
    public static int minOperations(int[][] grid, int x) {
        List<Integer> array = new ArrayList<>();
        int remainder = grid[0][0] % x;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] % x != remainder) {
                    return -1; 
                }
                array.add(grid[i][j]);
            }
        }

        Collections.sort(array);
        int n = array.size();
        int median = n / 2;

        int steps = 0;
        for (int i = 0; i < n; ++i) {
            steps += Math.abs(array.get(i) - array.get(median)) / x;
        }

        return steps;
    }
    public static void main(String[] args) {
        int grid[][] = {{2,4},{6,8}};
        int x = 2;
        System.out.println(minOperations(grid, x));
    }
}

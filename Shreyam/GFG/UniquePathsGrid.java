// Question: Unique Paths in a Grid

// You are given a 2d list grid[][] of size n x m consisting of values 0 and 1.
// A value of 0 means that you can enter that cell and 1 implies that entry to that cell is not allowed.
// You start at the upper-left corner of the grid (1, 1) and you have to reach the bottom-right corner (n, m) such that you can only move in the right or down direction from every cell.
// Your task is to calculate the total number of ways of reaching the target.
// Note: The first (1, 1) and last (n, m) cell of the grid can also be 1.
// It is guaranteed that the total number of ways will fit within a 32-bit integer.

// Examples:
// Input: n = 3, m = 3,
// grid[][] = [[0, 0, 0], [0, 1, 0], [0, 0, 0]]
// Output: 2


package shreyam.gfg;

import java.util.Arrays;

public class UniquePathsGrid {
    public static int uniquePaths(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        for(int[] d:dp) Arrays.fill(d,-1);
        return rec(0,0,grid,dp);
    }
    private static int rec(int i,int j,int grid[][],int dp[][]){
        if(i==grid.length || j==grid[0].length || grid[i][j]==1) return 0;
        if(i==grid.length-1 && j==grid[0].length-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int count=0;
        count+=rec(i+1,j,grid,dp);
        count+=rec(i,j+1,grid,dp);
        return dp[i][j]=count;
    }
    public static void main(String[] args) {
        // int n = 3, m = 3;
        int grid[][] = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        System.out.println(uniquePaths(grid));
    }
}

// Question: Gold Mine Problem 

// Given a gold mine called mat[][]. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially, the miner can start from any row in the first column. From a given cell, the miner can move -
// to the cell diagonally up towards the right
// to the right
// to the cell diagonally down towards the right
// Find out the maximum amount of gold that he can collect until he can no longer move.

// Examples:
// Input: mat[][] = [[1, 3, 3], [2, 1, 4], [0, 6, 4]]
// Output: 12


package shreyam.gfg;

public class GoldMineProblem {
    public static int maxGold(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for (int y = m - 2; y >= 0; y--) {
            for (int x = 0; x < n; x++) {
                int maxPrev = 0;

                if (x - 1 >= 0 && y + 1 < m) {
                    maxPrev = Math.max(maxPrev, mat[x - 1][y + 1]);
                }

                if (y + 1 < m) {
                    maxPrev = Math.max(maxPrev, mat[x][y + 1]);
                }

                if (x + 1 < n && y + 1 < m) {
                    maxPrev = Math.max(maxPrev, mat[x + 1][y + 1]);
                }

                mat[x][y] += maxPrev;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, mat[i][0]);
        }

        return result;
    }
    public static void main(String[] args) {
       int mat[][] = {{1, 3, 3}, {2, 1, 4}, {0, 6, 4}};
       System.out.println(maxGold(mat));
    }
}

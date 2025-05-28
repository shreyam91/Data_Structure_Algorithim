// Question: Find rectangle with corners as 1 

// Given an n x m binary matrix mat[][] containing only 0s and 1s, determine if there exists a rectangle within the matrix such that all four corners of the rectangle are 1. If such a rectangle exists, return true; otherwise, return false.

// Example:

// Input: mat[][] =
// [[1, 0, 0, 1, 0],
// [0, 0, 1, 0, 1],
// [0, 0, 0, 1, 0], 
// [1, 0, 1, 0, 1]] 
// Output: true

package shreyam.gfg;

public class FindRectangleCorners1 {
    public static boolean ValidCorner(int[][] mat) {
        int m = mat.length;        
        int n = mat[0].length;     

        for (int r1 = 0; r1 < m; r1++) {
            for (int r2 = r1 + 1; r2 < m; r2++) {
                for (int c1 = 0; c1 < n; c1++) {
                    for (int c2 = c1 + 1; c2 < n; c2++) {
                        if (mat[r1][c1] == 1 && mat[r1][c2] == 1 &&
                            mat[r2][c1] == 1 && mat[r2][c2] == 1) {
                            return true;
                        }
                    }
                }
            }
        }

        return false; 
    }
    public static void main(String[] args) {
        int[][] mat = {
            {1, 0, 0, 1, 0},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0}, 
            {1, 0, 1, 0, 1}
        };

        boolean result = ValidCorner(mat);
        System.out.println(result);
    }
}

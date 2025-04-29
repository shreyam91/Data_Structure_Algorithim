// Question: Set Matrix Zeroes... 
// You are given a 2D matrix mat[][] of size n×m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0 and do it in constant space complexity.

// Examples:
// Input: mat[][] = [[1, -1, 1],
//                 [-1, 0, 1],
//                 [1, -1, 1]]

// Output: [[1, 0, 1],
//         [0, 0, 0],
//         [1, 0, 1]]
// Explanation: mat[1][1] = 0, so all elements in row 1 and column 1 are updated to zeroes.

package shreyam.GFG160;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean rowFirst = false;
        boolean colFirst = false;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                colFirst = true;
                break;
            }
        }

        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                rowFirst = true;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowFirst) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (colFirst) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, -1, 1},
            {-1, 0, 1},
            {1, -1, 1}
        };

        SetMatrixZeroes smz = new SetMatrixZeroes();
        System.out.println("Original matrix:");
        printMatrix(mat);

        smz.setZeroes(mat);

        System.out.println("\nMatrix after setZeroes:");
        printMatrix(mat);
    }
}

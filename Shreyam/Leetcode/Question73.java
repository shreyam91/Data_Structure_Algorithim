// Question: Set Matrix Zeros 

// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.

// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

package shreyam.leetCode;

public class Question73{
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstCol = false;

    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[0].length; j++)
        if (matrix[i][j] == 0) {
          if (i == 0) firstRow = true;
          if (j == 0) firstCol = true;
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }

    for (int i = 1; i < matrix.length; i++)
      for (int j = 1; j < matrix[0].length; j++)
        if (matrix[i][0] == 0 || matrix[0][j] == 0)
          matrix[i][j] = 0;

    if (firstRow)
      for (int j = 0; j < matrix[0].length; j++)
        matrix[0][j] = 0;

    if (firstCol)
      for (int i = 0; i < matrix.length; i++)
        matrix[i][0] = 0;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int [] [] matrix = {{1,1,1},{1,0,1},{1,1,1}};
       Question73 q = new Question73();
        q.setZeroes(matrix);
        printMatrix(matrix);
    }
}
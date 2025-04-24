// Question: Spirally traversing a matrix... 
// You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while traversing the matrix in spiral form.

// Examples:
// Input: mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
// Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]


package shreyam.GFG160;

import java.util.ArrayList;

public class SpirallyTraversingMatrix {

    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        int r = mat.length;
        int c = mat[0].length;
        int up = 0;
        int down = r - 1;
        int left = 0;
        int right = c - 1;
        ArrayList<Integer> ans = new ArrayList<>();

        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                ans.add(mat[up][i]);
            }
            up++;

            for (int i = up; i <= down; i++) {
                ans.add(mat[i][right]);
            }
            right--;

            if (up > down || left > right) break;

            for (int i = right; i >= left; i--) {
                ans.add(mat[down][i]);
            }
            down--;

            for (int i = down; i >= up; i--) {
                ans.add(mat[i][left]);
            }
            left++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int mat[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        SpirallyTraversingMatrix solver = new SpirallyTraversingMatrix();
        ArrayList<Integer> result = solver.spirallyTraverse(mat);

        System.out.println(result);
    }
}

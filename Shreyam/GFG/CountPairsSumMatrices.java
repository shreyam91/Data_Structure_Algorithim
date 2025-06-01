// Question: Count pairs Sum in matrices

// Given two matrices mat1[][] and mat2[][] of size n x n, where the elements in each matrix are arranged in strictly ascending order. Specifically, each row is sorted from left to right, and the last element of a row is smaller than the first element of the next row.
// You're given a target value x, your task is to find and count all pairs {a, b} such that a is from mat1 and b is from mat2 where the sum of a + b is equal to x.

// Examples:

// Input: n = 3, x = 21,
// mat1[][] = [[1, 5, 6], [8, 10, 11], [15, 16, 18]],
// mat2[][] = [[2, 4, 7], [9, 10, 12], [13, 16, 20]]
// OUTPUT: 4

package shreyam.gfg;

public class CountPairsSumMatrices{
    static int countPairs(int[][] mat1, int[][] mat2, int x) {
        int r1 = 0, c1 = 0;
        int r2 = mat2.length - 1, c2 = mat2[0].length - 1;
        int count = 0;

        while (r1 < mat1.length && r2 >= 0) {
            int val = mat1[r1][c1] + mat2[r2][c2];

            if (val == x) {
                count++;
                c1++;
                c2--;
            } else if (val < x) {
                c1++;
            } else {
                c2--;
            }
            if (c1 == mat1[0].length) {
                c1 = 0;
                r1++;
            }
            if (c2 == -1) {
                c2 = mat2[0].length - 1;
                r2--;
            }
        }

        return count;
    }
    public static void main(String[] args) {
       int x = 21;
        int mat1[][] = {{1, 5, 6}, {8, 10, 11}, {15, 16, 18}};
        int mat2[][] = {{2, 4, 7}, {9, 10, 12}, {13, 16, 20}};

        System.out.println(countPairs(mat1, mat2, x));
    }
}

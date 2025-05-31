// Question: Kth element in Matrix

// Given a matrix mat[][] of size n*n, where each row and column is sorted in non-decreasing order. Find the kth smallest element in the matrix.

// Examples:
// Input: n = 4, mat[][] = [[16, 28, 60, 64], [22, 41, 63, 91], [27, 50, 87, 93], [36, 78, 87, 94]], k = 3
// Output: 27

package shreyam.gfg;

import java.util.ArrayList;
import java.util.List;

public class KthElementMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
       
        int n = matrix.length;

        List<Integer> result = new ArrayList<>(); 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.add(matrix[i][j]);
            }
        }
        result.sort(null);        
        return result.get(k - 1); 
    }
    public static void main(String[] args) {
    //    int n = 4;
       int mat[][] = {{6, 28, 60, 64}, {22, 41, 63, 91}, {27, 50, 87, 93}, {36, 78, 87, 94}}; 
       int k = 3;

        System.out.println(kthSmallest(mat, k));
    }
}

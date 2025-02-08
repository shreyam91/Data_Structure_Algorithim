// Question: First Completely painted row or Column.. 
// You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].
// Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].
// Return the smallest index i at which either a row or a column will be completely painted in mat.
// Example 1:
// Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
// Output: 2
// Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].

package Shreyam.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Question2661 {
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        Map<Integer, int[]> lookup = new HashMap<>();
        for(int i =0; i<m;i++){
            for(int j=0; j< n;j++){
                lookup.put(mat[i][j], new int[]{i,j});
            }
        }
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for( int i=0;i<arr.length;i++){
            int [] coordinate = lookup.get(arr[i]);
            int x = coordinate[0];
            int y = coordinate[1];

            rowCount[x]++;
            colCount[y]++;

            if(rowCount[x]==n || colCount[y]==m){
                return i;
            }
        }
            return 0;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,4,2};
        int [][]mat = {{1,4},{2,3}};
        int res = firstCompleteIndex(arr, mat);
        System.out.println(res);
    }
}

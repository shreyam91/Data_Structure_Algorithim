// Question: Matrix Chain Manipulation... 
// Given an array arr[] which represents the dimensions of a sequence of matrices where the ith matrix has the dimensions (arr[i-1] x arr[i]) for i>=1, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.

// Examples:
// Input: arr[] = [2, 1, 3, 4]
// Output: 20

package shreyam.gfg;

import java.util.Arrays;

public class MatrixChainManipulation {
    public static int helper(int start, int end, int[] arr, int[][] dp) {
            if (end - start == 1) return 0;
    
            if (dp[start][end] != -1) return dp[start][end];
            
            int ans = Integer.MAX_VALUE;  
            
            for (int k = start + 1; k < end; k++) {
                int left = helper(start, k, arr, dp);
                int right = helper(k, end, arr, dp);
                
                ans = Math.min(ans, left + right + arr[start] * arr[k] * arr[end]);
            }
            
            dp[start][end] = ans;
            
            return ans;
        }
    
        static int matrixMultiplication(int arr[]) {
               int n = arr.length;
            
            int[][] dp = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }
            
            return helper(0, n - 1, arr, dp);
    }
    public static void main(String[] args) {
        int arr[] = {2,1,3,4};
        int res = matrixMultiplication(arr);
        System.out.println(res);
    }
}

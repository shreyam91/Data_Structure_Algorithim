// Question: Find Subsequence of Length K With the Largest Sum

// You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.
// Return any such subsequence as an integer array of length k.
// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

// Example 1:
// Input: nums = [2,1,3,3], k = 2
// Output: [3,3]


package shreyam.leetCode;

import java.util.Arrays;

public class Question2099{
    public static int[] maxSubsequence(int[] nums, int k) {
       int n = nums.length;
        int[][] vals = new int[n][2]; 
        for (int i = 0; i < n; ++i) {
            vals[i][0] = i; 
            vals[i][1] = nums[i]; 
        }
        Arrays.sort(vals, (x1, x2) -> Integer.compare(x2[1], x1[1]));
        Arrays.sort(vals, 0, k, (x1, x2) -> Integer.compare(x1[0], x2[0]));
        int[] res = new int[k]; 
        for (int i = 0; i < k; ++i) {
            res[i] = vals[i][1];
        }
        return res;
        
    }
    public static void main(String[] args) {
        int nums[] ={2,1,3,3};
        int k =2;
        System.out.println(Arrays.toString(maxSubsequence(nums, k)));
    }
}
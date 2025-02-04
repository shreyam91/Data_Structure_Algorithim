// Question: Maximum Ascending SubArray Sum... 
// Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.
// A subarray is defined as a contiguous sequence of numbers in an array.
// A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.

// Example 1:
// Input: nums = [10,20,30,5,10,50]
// Output: 65
// Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.

package Shreyam.LeetCode;

public class Question1800 {
    public static int maxAscendingSum(int[] nums){
        int n = nums.length;
        int r = 1, sum = nums[0], maxSum = nums[0];

        while(r<n){
            while(r < n && nums[r] > nums[r-1]){
                sum += nums[r];
                r++;
            }
            maxSum = Math.max(maxSum, sum);
            if(r<n){
                sum = nums[r];
            }
            r++;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] num = {10,20,30,5,10,50};
        int res = maxAscendingSum(num);
        System.out.println(res);
    }
}

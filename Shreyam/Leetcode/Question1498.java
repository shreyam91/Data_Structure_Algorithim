// Question: Number of Subsequences That Satisfy the Given Sum Condition 

// You are given an array of integers nums and an integer target.
// Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.

// Example 1:
// Input: nums = [3,5,6,7], target = 9
// Output: 4

package shreyam.leetCode;

import java.util.Arrays;

public class Question1498 {
    final static int MOD = (int)1e9 + 7;
    
    private static void precomputePowerOfTwo(int[] powerOfTwo, int n) {
        powerOfTwo[0] = 1;
        for (int i = 1; i < n; ++i) {
            powerOfTwo[i] = (int)((powerOfTwo[i - 1] * 2L) % MOD);
        }
    }
    
    public static int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int[] powerOfTwo = new int[n];
        precomputePowerOfTwo(powerOfTwo, n);
        
        Arrays.sort(nums);
        int subsequences = 0;
        
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                subsequences = (subsequences + powerOfTwo[right - left]) % MOD;
                left++;
            }
        }
        return subsequences;
    }
    public static void main(String[] args) {
       int[] nums = {3,5,6,7};
       int target = 9;
       System.out.println(numSubseq(nums, target));
    }
}

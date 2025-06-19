// Question: Partition Array Such That Maximum Difference Is K 

// You are given an integer array nums and an integer k. You may partition nums into one or more subsequences such that each element in nums appears in exactly one of the subsequences.
// Return the minimum number of subsequences needed such that the difference between the maximum and minimum values in each subsequence is at most k.
// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

// Example 1:
// Input: nums = [3,6,1,2,5], k = 2
// Output: 2

package shreyam.leetCode;

import java.util.Arrays;

public class Question2294 {
    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int subsequences = 1;
        int min_val = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - min_val > k) {
                min_val = nums[i];
                subsequences++;
            }
        }
        return subsequences;
    }
    public static void main(String[] args) {
        int nums[] = {3,6,1,2,5};
        int k = 2;
        System.out.println(partitionArray(nums, k));
    }
}

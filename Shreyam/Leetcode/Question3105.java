// Question: Longest Strictly Increasing or Strictly Decreasing Subarray
// You are given an array of integers nums. Return the length of the longest 
// subarray of nums which is either strictly increasing or strictly decreasing.

// Example 1:
// Input: nums = [1,4,3,3,2]
// Output: 2
// Explanation:
// The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].
// The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].
// Hence, we return 2.

package Shreyam.LeetCode;

public class Question3105 {
    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int longest = 1;
        int strictlyIncreasing = 1;
        int strictlyDecreasing = 1;
        
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) {
                strictlyIncreasing++;
                strictlyDecreasing = 1;
            } else if (nums[i] < nums[i - 1]) {
                strictlyDecreasing++;
                strictlyIncreasing = 1;
            } else {
                strictlyIncreasing = 1;
                strictlyDecreasing = 1;
            }
            
            longest = Math.max(longest, Math.max(strictlyIncreasing, strictlyDecreasing));
        }
        
        return longest;
    }
    public static void main(String[] args) {
        int [] nums = {1,4,3,3,2};
        int res = longestMonotonicSubarray(nums);
        System.out.println(res);
    }
}

// Question: Maximum Absolute Sum of Any Subarray... 
// You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
// Return the maximum absolute sum of any (possibly empty) subarray of nums.
// Note that abs(x) is defined as follows:
// If x is a negative integer, then abs(x) = -x.
// If x is a non-negative integer, then abs(x) = x.
 
// Example 1:
// Input: nums = [1,-3,2,3,-4]
// Output: 5
// Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.

package shreyam.leetCode;

public class Question1749 {
    private static int maxSumSubarrayKadanes(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static int maxAbsoluteSum(int[] nums) {
        int maxSumSubarray = maxSumSubarrayKadanes(nums);

        // Flip all signs
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }

        int minSumSubarray = maxSumSubarrayKadanes(nums);
        return Math.max(maxSumSubarray, minSumSubarray);
    }
    public static void main(String[] args) {
        int [] nums = {1,-3,2,3,-4};
        int res = maxAbsoluteSum(nums);
        System.out.println(res);
    }
}

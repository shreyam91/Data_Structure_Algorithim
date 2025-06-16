// Question: Maximum Difference Between Increasing Elements

// Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].
// Return the maximum difference. If no such i and j exists, return -1.

// Example 1:
// Input: nums = [7,1,5,4]
// Output: 4


package shreyam.leetCode;

public class Question2016 {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int minElement = nums[0];
        int maxDiff = -1;

        for (int j = 1; j < n; j++) {
            if (nums[j] > minElement) {
                maxDiff = Math.max(maxDiff, nums[j] - minElement);
            } else {
                minElement = nums[j];
            }
        }

        return maxDiff;
    }
    public static void main(String[] args) {
        
    }
}

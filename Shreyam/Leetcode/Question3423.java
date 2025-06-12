// Question: Maximum Difference Between Adjacent Elements in a Circular Array 

// Given a circular array nums, find the maximum absolute difference between adjacent elements.
// Note: In a circular array, the first and last elements are adjacent.

// Example 1:
// Input: nums = [1,2,4]
// Output: 3

package shreyam.leetCode;

public class Question3423 {
    public static int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
    int maxDiff = Math.abs(nums[0] - nums[n - 1]);
    for (int i = 1; i < n; i++) {
        maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i - 1]));
    }
    return maxDiff;
    }
    public static void main(String[] args) {
        int [] nums = {1,2,4};
        System.out.println(maxAdjacentDistance(nums));
    }
    
}

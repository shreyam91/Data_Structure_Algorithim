// Question: Maximum Value of an Ordered Triplet II... 

// You are given a 0-indexed integer array nums.
// Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.
// The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].

// Example 1:
// Input: nums = [12,6,1,2,7]
// Output: 77


package shreyam.leetCode;

public class Question2874 {
    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxDiff = 0;
        long maxLeft = 0;
        long maxVal = 0;
        for (int i = 0; i < n; ++i) {
            maxVal = Math.max(maxVal, maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff, maxLeft - nums[i]);
            maxLeft = Math.max(maxLeft, nums[i]);
        }
        return maxVal;
    }
    public static void main(String[] args) {
        int nums [] = {12,6,1,2,7};
        long result = maximumTripletValue(nums);
        System.out.println(result);
    }
}

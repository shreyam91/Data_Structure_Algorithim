// Question: Maximum Erasure Value

// You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
// Return the maximum score you can get by erasing exactly one subarray.
// An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

// Example 1:
// Input: nums = [4,2,4,5,6]
// Output: 17

package shreyam.leetCode;

import java.util.HashMap;

public class Question1695 {
    public static int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        HashMap<Integer, Boolean> valIdx = new HashMap<>();

        int maxSum = Integer.MIN_VALUE;
        int winSum = 0;
        while (right < n) {
            if (valIdx.containsKey(nums[right])) {
                valIdx.remove(nums[left]);
                winSum -= nums[left];
                left++;
            } else {
                winSum += nums[right];
                valIdx.put(nums[right], true);
                right++;
                maxSum = Math.max(maxSum, winSum);
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
       int nums [] = {4,2,4,5,6};
        System.out.println(maximumUniqueSubarray(nums));
    }
}

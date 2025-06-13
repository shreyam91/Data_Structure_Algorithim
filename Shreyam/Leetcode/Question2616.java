// Question: Minimize the Maximum Difference of Pairs
// You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the p pairs.
// Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.
// Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.

// Example 1:
// Input: nums = [10,1,2,7,1,3], p = 2
// Output: 1

package shreyam.leetCode;

import java.util.Arrays;

public class Question2616 {
    public static boolean possiblePairs(int[] nums, int diff, int p) {
        int n = nums.length;
        int pairs = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= diff) {
                pairs++;
                i++; 
            }
        }
        return pairs >= p;
    }

    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = nums[n - 1] - nums[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possiblePairs(nums, mid, p)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int [] nums = {10,1,2,7,1,3};
        int p = 2;
        System.out.println(minimizeMax(nums, p));
    }
}

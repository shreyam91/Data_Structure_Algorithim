// Question: Count the Number of Fair Pairs... 
// Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
// A pair (i, j) is fair if:
// 0 <= i < j < n, and
// lower <= nums[i] + nums[j] <= upper
 

// Example 1:
// Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
// Output: 6

package shreyam.leetCode;

import java.util.Arrays;

public class Question2563 {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        
        long ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            int lb = lowerBound(nums, i + 1, n, lower - nums[i]);
            int ub = upperBound(nums, i + 1, n, upper - nums[i]);
            ans += (ub - lb);
        }
        return ans;
    }
    
    private static int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    private static int upperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) start = mid + 1;
            else end = mid;
        }
        return start;
    }
    public static void main(String[] args) {
        int nums[] = {0,1,7,4,4,5};
        int lower = 3, upper = 6;

        long res = countFairPairs(nums, lower, upper);
        System.out.println(res);
    }
}
